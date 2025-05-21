package model;

public class Product {
	private String productCode;
	private String productName;
	private Author author;
	private int publication;
	private double importPrice;
	private double exportPrice;
	private double sellingPriceProduct;
	private int quantity;
	private Category category;
	private String language;
	private String description;
	
	public Product() {
	}

	public Product(String productCode, String productName, Author author, int publication, double importPrice,
			double exportPrice, double sellingPriceProduct, int quantity, Category category, String language,
			String description) {
		this.productCode = productCode;
		this.productName = productName;
		this.author = author;
		this.publication = publication;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.sellingPriceProduct = sellingPriceProduct;
		this.quantity = quantity;
		this.category = category;
		this.language = language;
		this.description = description;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPublication() {
		return publication;
	}

	public void setPublication(int publication) {
		this.publication = publication;
	}

	public double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
	}

	public double getExportPrice() {
		return exportPrice;
	}

	public void setExportPrice(double exportPrice) {
		this.exportPrice = exportPrice;
	}

	public double getSellingPriceProduct() {
		return sellingPriceProduct;
	}

	public void setSellingPriceProduct(double sellingPriceProduct) {
		this.sellingPriceProduct = sellingPriceProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
