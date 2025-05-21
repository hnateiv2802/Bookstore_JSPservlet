package model;

public class OrderDetail {
	private String oderDetailCode;
	private Order order;
	private Product product;
	private double quantity;
	private double originalPrice;
	private double discount;
	private	double sellingPriceOrderDetail;
	private double VAT;
	private double totalAmount;
	
	public OrderDetail() {

	}

	public OrderDetail(String oderDetailCode, Order order, Product product, double quantity, double originalPrice,
			double discount, double sellingPriceOrderDetail, double vAT, double totalAmount) {
		this.oderDetailCode = oderDetailCode;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.discount = discount;
		this.sellingPriceOrderDetail = sellingPriceOrderDetail;
		VAT = vAT;
		this.totalAmount = totalAmount;
	}

	public String getOderDetailCode() {
		return oderDetailCode;
	}

	public void setOderDetailCode(String oderDetailCode) {
		this.oderDetailCode = oderDetailCode;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSellingPriceOrderDetail() {
		return sellingPriceOrderDetail;
	}

	public void setSellingPriceOrderDetail(double sellingPriceOrderDetail) {
		this.sellingPriceOrderDetail = sellingPriceOrderDetail;
	}

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		VAT = vAT;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
