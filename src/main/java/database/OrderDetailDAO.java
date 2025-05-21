package database;

import java.util.ArrayList;

import model.Order;
import model.OrderDetail;

public class OrderDetailDAO {
	ArrayList<OrderDetail> data = new ArrayList<OrderDetail>();
	
	public ArrayList<OrderDetail> selectAll() {
		return data;
	}
	
	public OrderDetail selectById(String id) {
		OrderDetail check = new OrderDetail();
		check.setOderDetailCode(id);
		for (OrderDetail orderDetail : data) {
			if(orderDetail.getOderDetailCode().equals(check)) {
				return orderDetail;
			}
		}
		return null;
	}
	
	public int insert(OrderDetail orderDetail) {
		OrderDetail checkExistOrder = this.selectById(orderDetail.getOderDetailCode());
		if(checkExistOrder == null) {
			data.add(orderDetail);
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<OrderDetail> list) {
		int count = 0;
		for (OrderDetail orderDetail : list) {
			count += this.insert(orderDetail);
		}
		return count;
	}
	
	public int delete(OrderDetail orderDetail) {
		OrderDetail checkExistOrder = this.selectById(orderDetail.getOderDetailCode());
		if(checkExistOrder != null) {
			data.remove(orderDetail);
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<OrderDetail> list) {
		int count = 0;
		for(OrderDetail item : list) {
			count += this.delete(item);
		}
		return count;
	}
	
	public int deleteAll(Order order) {
		int dem = 0;
		for (OrderDetail orderDetail : data) {
			if(orderDetail.getOrder().equals(order)) {
				this.delete(orderDetail);
			}
		}
		return dem;
	}
	
	public int update(OrderDetail orderDetail) {
		OrderDetail checkExist = this.selectById(orderDetail.getOderDetailCode());
		if (checkExist != null) {
			data.remove(checkExist);
			data.add(orderDetail);
			return 1;
		} else {
			return 0;
		}
	}
}
