package database;

import java.util.ArrayList;

import model.Order;

public class OrderDAO {
	ArrayList<Order> data = new ArrayList<Order>();
	
	public ArrayList<Order> selectAll() {
		return data;
	}
	
	public Order selectById(String id) {
		Order checkOrder = new Order();
		checkOrder.setOderCode(id);
		for(Order item : data) {
			if(item.equals(checkOrder)) {
				return item;
			}
		}
		return null;
	}
	
	public int insert(Order order) {
		Order checkExist = this.selectById(order.getOderCode());
		if(checkExist == null) {
			data.add(order);
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int insertAll (ArrayList<Order> list) {
		int count = 0;
		for(Order item : list) {
			count += this.insert(item);
		}
		return count;
	}
	
	public int delete(Order order) {
		Order checkExistOrder = this.selectById(order.getOderCode());
		if (checkExistOrder != null) {
			// Xoa di cac chi tiet don hang
			OrderDetailDAO orderDetail = new OrderDetailDAO();
			orderDetail.deleteAll(order);
			
			// Xoa don hang
			data.remove(order);
			return 1;
		} else {
			return 0;
		}
	}
}
