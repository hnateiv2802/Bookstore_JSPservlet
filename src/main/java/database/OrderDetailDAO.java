package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderDetail;
import model.Product;
import model.Order;
import model.OrderDetail;

public class OrderDetailDAO implements DAOinteface<OrderDetail> {
	private ArrayList<OrderDetail> data = new ArrayList<OrderDetail>();

	@Override
	public ArrayList<OrderDetail> selectAll() {
		ArrayList<OrderDetail> result = new ArrayList<OrderDetail>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM orderdetail";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:

			while (rs.next()) {
				String oderDetailCode = rs.getString("oderdetailcode");
				String orderCode = rs.getString("ordercode");
				String productCode = rs.getString("productcode");
				double quantity = rs.getDouble("quantity");
				double originalPrice = rs.getDouble("originalprice");
				double discount = rs.getDouble("discount");
				double sellingPriceOrderDetail = rs.getDouble("sellingpriceorderdetail");
				double VAT = rs.getDouble("VAT");
				double totalAmount = rs.getDouble("totalamount");

				
				Order order = new OrderDAO().selectById(new Order(orderCode, null, "", "", "", "", "", 0, 0, null, null));
				Product product = new ProductDAO().selectById(new Product("", "", null, 0, 0, 0, 0, 0, null, "", ""));
				OrderDetail orderDetail = new OrderDetail(oderDetailCode, order, product, quantity, originalPrice, discount, sellingPriceOrderDetail, VAT, totalAmount);
				result.add(orderDetail);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public OrderDetail selectById(OrderDetail t) {
		OrderDetail result = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM orderdetail WHERE orderdetailcode=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOderDetailCode());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String oderDetailCode = rs.getString("oderdetailcode");
				String orderCode = rs.getString("ordercode");
				String productCode = rs.getString("productcode");
				double quantity = rs.getDouble("quantity");
				double originalPrice = rs.getDouble("originalprice");
				double discount = rs.getDouble("discount");
				double sellingPriceOrderDetail = rs.getDouble("sellingpriceorderdetail");
				double VAT = rs.getDouble("VAT");
				double totalAmount = rs.getDouble("totalamount");

				Order order = new OrderDAO().selectById(new Order(orderCode, null, "", "", "", "", "", 0, 0, null, null));
				Product product = new ProductDAO().selectById(new Product("", "", null, 0, 0, 0, 0, 0, null, "", ""));

				result = new OrderDetail(oderDetailCode, order, product, quantity, originalPrice, discount, sellingPriceOrderDetail, VAT, totalAmount);
				break;
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insert(OrderDetail t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO chitietdonhang (oderdetailcode, ordercode,productcode, quantity, originalprice,discount,sellingpriceorderdetail,VAT,totalamount) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOderDetailCode());
			st.setString(2, t.getOrder().getOderCode());
			st.setString(3, t.getProduct().getProductCode());
			st.setDouble(4, t.getQuantity());
			st.setDouble(5, t.getOriginalPrice());
			st.setDouble(7, t.getDiscount());
			st.setDouble(6, t.getSellingPriceOrderDetail());
			st.setDouble(8, t.getVAT());
			st.setDouble(9, t.getTotalAmount());
			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insertAll(ArrayList<OrderDetail> arr) {
		int count = 0;
		for (OrderDetail OrderDetail : arr) {
			count += this.insert(OrderDetail);
		}
		return count;
	}

	@Override
	public int delete(OrderDetail t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from orderdetail " + " WHERE orderdetailcode=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOderDetailCode());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteAll(ArrayList<OrderDetail> arr) {
		int count = 0;
		for (OrderDetail OrderDetail : arr) {
			count += this.delete(OrderDetail);
		}
		return count;
	}
	
//	public int deleteAll(Order order) {
//		int count = 0;
//		for (OrderDetail OrderDetail : data) {
//			if(OrderDetail.getOrder().equals(order));
//			this.delete(OrderDetail);
//		}
//		return count;
//	}
	
	@Override
	public int update(OrderDetail t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE chitietdonhang SET ordercode=?, productcode=?, quantity=?, originalprice=?, discount=?, sellingpriceorderdetail=?, VAT=?, totalamount=?"
					+ " WHERE oderdetailcode=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrder().getOderCode());
			st.setString(2, t.getProduct().getProductCode());
			st.setDouble(3, t.getQuantity());
			st.setDouble(4, t.getOriginalPrice());
			st.setDouble(5, t.getDiscount());
			st.setDouble(6, t.getSellingPriceOrderDetail());
			st.setDouble(7, t.getVAT());
			st.setDouble(8, t.getTotalAmount());
			st.setString(9, t.getOderDetailCode());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
