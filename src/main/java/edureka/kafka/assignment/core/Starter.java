package edureka.kafka.assignment.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Starter {

	public static volatile long number = 10000;

	public static void main(String[] args) {

		Starter instance = new Starter();
		instance.start();

	}

	public void start() {

		// instantiate producer
		InputStream propsFile = Starter.class.getResourceAsStream("producer.props");
		Producer<String, Data> producer;
		Properties props = null;
		try {
			props = loadProperties(propsFile);
		} catch (IOException e) {
			System.out.println("Producer properties read exception!");
			e.printStackTrace();
		}
		producer = new KafkaProducer<String, Data>(props);

		// thread inits
		ExecutorService executor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		for (int i = 0; i < Integer.valueOf(props.getProperty("threads", "1")); i++) {

			tasks.add(getProducerTask(producer, props.getProperty("topic")));

		}
		try {
			executor.invokeAll(tasks);
		} catch (InterruptedException e) {
			System.out.println("Something went wrong in task execution");
			e.printStackTrace();
		}
		try {
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
		
		System.out.println("shutting down program execution");

	}

	private Properties loadProperties(InputStream inputStream) throws IOException {
		Properties props = new Properties();
		props.load(inputStream);
		return props;
	}

	private Callable<String> getProducerTask(Producer<String, Data> producer, String topic) {

		return new Callable<String>() {

			@Override
			public String call() throws Exception {

				while (Starter.number > 0) {
					Starter.number--;
					ProducerRecord<String, Data> record = new ProducerRecord<String, Data>(topic, new Data());
					RecordMetadata metadata = producer.send(record).get();
					System.out.println(metadata.topic());
				}
				return "";
				
			}

		};

	}

}
