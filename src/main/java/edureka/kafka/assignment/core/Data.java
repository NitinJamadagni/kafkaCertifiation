package edureka.kafka.assignment.core;

public class Data {
	private String pogId;
	private String supc;
	private String brand;
	private String description;
	private String size;
	private String category;
	private String subCategory;
	private double price;
	private int qunatity;
	private String country;
	private String sellerCode;
	private String creationTime;
	private int stock;
	
	public Data() {
		this.pogId = "1234";
		this.supc = "abcd";
		this.brand = "A&F";
		this.description = "apparels";
		this.size = "M";
		this.category = "Mens";
		this.subCategory = "Shirts";
		this.price = 20.0;
		this.qunatity = 2;
		this.country = "USA";
		this.sellerCode = "abcd";
		this.creationTime = "30/09/2018";
		this.stock = 100;
	}
	
	public Data(String pogId, String supc, String brand, String description, String size, String category,
			String subCategory, double price, int qunatity, String country, String sellerCode, String creationTime,
			int stock) {
		super();
		this.pogId = pogId;
		this.supc = supc;
		this.brand = brand;
		this.description = description;
		this.size = size;
		this.category = category;
		this.subCategory = subCategory;
		this.price = price;
		this.qunatity = qunatity;
		this.country = country;
		this.sellerCode = sellerCode;
		this.creationTime = creationTime;
		this.stock = stock;
	}


	public String getPogId() {
		return pogId;
	}


	public void setPogId(String pogId) {
		this.pogId = pogId;
	}


	public String getSupc() {
		return supc;
	}


	public void setSupc(String supc) {
		this.supc = supc;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQunatity() {
		return qunatity;
	}


	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getSellerCode() {
		return sellerCode;
	}


	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}


	public String getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
	
	
}
