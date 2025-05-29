package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Order;
import model.Order;
import model.Order;

public class OrderDAO implements DAOinteface<Order> {
	private ArrayList<Order> data = new ArrayList<Order>();

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> result = new ArrayList<Order>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM order";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String oderCode = rs.getString(1);
				String customerCode = rs.getString(2);
				String deliveryOrderAddress = rs.getString(3);
				String purchaseOrderAddress = rs.getString(4);
				String status = rs.getString(5);
				String formPayment = rs.getString(6);
				String statusPayment = rs.getString(7);
				double amountPaid = rs.getDouble(8);
				double missingPaid = rs.getDouble(9);
				Date dateOrder = rs.getDate(10);
				Date dateDelivery = rs.getDate(11);

				Customer customer = new CustomerDAO().selectById(new Customer(customerCode, "", "", "", "", "", "", "", null, "", "", false));
				Order order = new Order(oderCode, customer, deliveryOrderAddress, purchaseOrderAddress, 
						status, formPayment, statusPayment, amountPaid, missingPaid, dateOrder, dateDelivery);
				result.add(order);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order selectById(Order t) {
		Order result = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang WHERE ordercode = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOderCode());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String oderCode = rs.getString(1);
				String customerCode = rs.getString(2);
				String deliveryOrderAddress = rs.getString(3);
				String purchaseOrderAddress = rs.getString(4);
				String status = rs.getString(5);
				String formPayment = rs.getString(6);
				String statusPayment = rs.getString(7);
				double amountPaid = rs.getDouble(8);
				double missingPaid = rs.getDouble(9);
				Date dateOrder = rs.getDate(10);
				Date dateDelivery = rs.getDate(11);

				Customer customer = new CustomerDAO().selectById(new Customer(customerCode, "", "", "", "", "", "", "", null, "", "", false));
				Order order = new Order(oderCode, customer, deliveryOrderAddress, purchaseOrderAddress, 
						status, formPayment, statusPayment, amountPaid, missingPaid, dateOrder, dateDelivery);

				result = order;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int insert(Order t) {
		int result = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang(ordercode, customercode, deliveryorderaddress, purchaseorderaddress, status, formpayment, statuspayment, amountpaid,missingpaid,dateorder,datedelivery)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOderCode());
			st.setString(2, t.getCustomer().getCustomerCode());
			st.setString(3, t.getDeliveryOrderAddress());
			st.setString(4, t.getPurchaseOrderAddress());
			st.setString(5, t.getStatus());
			st.setString(6, t.getFormPayment());
			st.setString(7, t.getStatusPayment());
			st.setDouble(8, t.getAmountPaid());
			st.setDouble(9, t.getMissingPaid());
			st.setDate(10, t.getDateOrder());
			st.setDate(11, t.getDateDelivery());

			result = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<Order> arr) {
		int count = 0;
		for (Order Order : arr) {
			count += this.insert(Order);
		}
		return count;
	}

	@Override
	public int delete(Order t) {
		int result = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE ordercode = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOderCode());
			result = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(ArrayList<Order> arr) {
		int count = 0;
		for (Order order : arr) {
			count += this.delete(order);
		}
		return count;
	}

	@Override
	public int update(Order t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();

		String sql = "UPDATE order" + " SET " + "customercode=?" + ", deliveryorderaddress=?" + ",purchaseorderaddress=?"
				+ ",status=?" + ",formpayment=?" + ",statuspayment=?" + ",amountpaid=?" + ",missingpaid=?"
				+ ",dateorder=?" + ",datedelivery=?"+ " WHERE orodercode=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);			
			st.setString(1, t.getCustomer().getCustomerCode());
			st.setString(2, t.getDeliveryOrderAddress());
			st.setString(3, t.getPurchaseOrderAddress());
			st.setString(4, t.getStatus());
			st.setString(5, t.getFormPayment());
			st.setString(6, t.getStatusPayment());
			st.setDouble(7, t.getAmountPaid());
			st.setDouble(8, t.getMissingPaid());
			st.setDate(9, t.getDateOrder());
			st.setDate(10, t.getDateDelivery());
			st.setString(11, t.getOderCode());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;

	}


}
