package database;

import java.util.ArrayList;

import model.Customer;

public class CustomerDAO {
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public ArrayList<Customer> selectAll() {
		return customers;
	}
	
	public Customer selectById(String id) {
		for (Customer customer : customers) {
			if(customer.getCustomerCode().equals(id)) {
				return customer;
			}
		}
		return null;
	}
	
	public int insert(Customer customer) {
		Customer checkExist = this.selectById(customer.getCustomerCode());
		if(checkExist == null) {
			customers.add(customer);
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<Customer> list) {
		int count = 0;
		for (Customer customer : list) {
			count += this.insert(customer);
		}
		return count;
	}
	
	public int delete(Customer customer) {
		Customer checkExist = this.selectById(customer.getCustomerCode());
		if(checkExist != null) {
			customers.remove(customer);
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<Customer> list) {
		int dem = 0;
		for (Customer customer : list) {
			Customer checkExist = this.selectById(customer.getCustomerCode());
			if (checkExist != null) {
				customers.remove(customer);
				dem++;
			}
		}
		return dem;
	}

	public int update(Customer customer) {
		Customer checkExist = this.selectById(customer.getCustomerCode());
		if (checkExist != null) {
			customers.remove(checkExist);
			customers.add(customer);
			return 1;
		} else {
			return 0;
		}
	}
}
