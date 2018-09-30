package edureka.kafka.assignment.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

public class Starter {

	public static void main(String[] args) {
		
		
		Starter instance = new Starter();
		instance.start();
		
		
	}
	
	public void start() {
		
		// instantiate producer
		InputStream propsFile = Starter.class.getResourceAsStream("producer.props");
		Producer<String, Data> producer;
		try {
			
			producer = new KafkaProducer<String, Data>(loadProperties(propsFile));
		
		} catch (IOException e) {
			
			System.out.println("Producer properties read exception!");
			e.printStackTrace();
		
		}
		
		
		
		
	}
	
	
	private Properties loadProperties(InputStream inputStream) throws IOException {
		Properties props = new Properties();
		props.load(inputStream);
		return props;
	}

}
