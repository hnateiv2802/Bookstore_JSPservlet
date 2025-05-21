package model;

import java.util.Date;

// khách hàng
public class Customer {
	private String customerCode;
	private String customerLoginName;
	private String password; 
	private String customerName;
	private String sex;
	private String address; // xa, huyen, tinh
	private String 	deliveryAddress;
	private String 	purchaseAddress;
	private Date dateOfBirth;
	private String phoneNumber;
	private String email;
	private boolean signUpNewsletter;
	
	public Customer() {
	}

	public Customer(String customerCode, String customerLoginName, String password, String customerName, String sex,
			String address, String deliveryAddress, String purchaseAddress, Date dateOfBirth, String phoneNumber,
			String email, boolean signUpNewsletter) {
		this.customerCode = customerCode;
		this.customerLoginName = customerLoginName;
		this.password = password;
		this.customerName = customerName;
		this.sex = sex;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.purchaseAddress = purchaseAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.signUpNewsletter = signUpNewsletter;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerLoginName() {
		return customerLoginName;
	}

	public void setCustomerLoginName(String customerLoginName) {
		this.customerLoginName = customerLoginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getPurchaseAddress() {
		return purchaseAddress;
	}

	public void setPurchaseAddress(String purchaseAddress) {
		this.purchaseAddress = purchaseAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSignUpNewsletter() {
		return signUpNewsletter;
	}

	public void setSignUpNewsletter(boolean signUpNewsletter) {
		this.signUpNewsletter = signUpNewsletter;
	}
	
	
	
}
