package model;

import java.sql.Date;
import java.util.Objects;

public class Order {
	private String oderCode;
	private Customer customer;
	private String deliveryOrderAddress;
	private String purchaseOrderAddress;
	private String status;
	private String formPayment; 
	private String statusPayment;
	private double amountPaid;
	private double missingPaid;
	private Date dateOrder;
	private Date dateDelivery;
	
	public Order() {

	}

	public Order(String oderCode, Customer customer, String deliveryOrderAddress, String purchaseOrderAddress,
			String status, String formPayment, String statusPayment, double amountPaid, double missingPaid,
			Date dateOrder, Date dateDelivery) {
		this.oderCode = oderCode;
		this.customer = customer;
		this.deliveryOrderAddress = deliveryOrderAddress;
		this.purchaseOrderAddress = purchaseOrderAddress;
		this.status = status;
		this.formPayment = formPayment;
		this.statusPayment = statusPayment;
		this.amountPaid = amountPaid;
		this.missingPaid = missingPaid;
		this.dateOrder = dateOrder;
		this.dateDelivery = dateDelivery;
	}

	public String getOderCode() {
		return oderCode;
	}

	public void setOderCode(String oderCode) {
		this.oderCode = oderCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryOrderAddress() {
		return deliveryOrderAddress;
	}

	public void setDeliveryOrderAddress(String deliveryOrderAddress) {
		this.deliveryOrderAddress = deliveryOrderAddress;
	}

	public String getPurchaseOrderAddress() {
		return purchaseOrderAddress;
	}

	public void setPurchaseOrderAddress(String purchaseOrderAddress) {
		this.purchaseOrderAddress = purchaseOrderAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormPayment() {
		return formPayment;
	}

	public void setFormPayment(String formPayment) {
		this.formPayment = formPayment;
	}

	public String getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getMissingPaid() {
		return missingPaid;
	}

	public void setMissingPaid(double missingPaid) {
		this.missingPaid = missingPaid;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	@Override
	public int hashCode() {
		return Objects.hash(oderCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(oderCode, other.oderCode);
	}


	
	
}
