package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Customer;

public class CustomerDAO implements DAOinteface<Customer>{
	private ArrayList<Customer> data = new ArrayList<Customer>();

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String customerCode = rs.getString("customercode");
				String customerLoginName = rs.getString("customerloginname");
				String password = rs.getString("password");
				String customerName = rs.getString("customername");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryaddress");
				String purchaseAddress = rs.getString("purchaseaddress");
				Date dateOfBirth = rs.getDate("dateofbirth");
				String phoneNumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean signUpNewsletter = rs.getBoolean("signupnewsletter");

				Customer customer = new Customer(customerCode, customerLoginName, password, 
											customerName, sex, address, deliveryAddress, purchaseAddress, dateOfBirth, phoneNumber, email, signUpNewsletter);
				result.add(customer);
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
	public Customer selectById(Customer t) {
		Customer result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE customercode=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomerCode());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String customerCode = rs.getString("customercode");
				String customerLoginName = rs.getString("customerloginname");
				String password = rs.getString("password");
				String customerName = rs.getString("customername");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryaddress");
				String purchaseAddress = rs.getString("purchaseaddress");
				Date dateOfBirth = rs.getDate("dateofbirth");
				String phoneNumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean signUpNewsletter = rs.getBoolean("signupnewsletter");

				result = new Customer(customerCode, customerLoginName, password, customerName, sex, 
							address, deliveryAddress, purchaseAddress, dateOfBirth, phoneNumber, email, signUpNewsletter);
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
	public int insert(Customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO customer (customercode, customerloginname, password, customername, sex, address, deliveryaddress, purchaseaddress, dateofbirth, phonenumber, email, signupnewsletter) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomerCode());
			st.setString(2, t.getCustomerLoginName());
			st.setString(3, t.getPassword());
			st.setString(4, t.getCustomerName());
			st.setString(5, t.getSex());
			st.setString(6, t.getAddress());
			st.setString(7, t.getDeliveryAddress());
			st.setString(8, t.getPurchaseAddress());
			st.setDate(9, (Date) t.getDateOfBirth());
			st.setString(10, t.getPhoneNumber());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.isSignUpNewsletter());

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
	public int insertAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer customer : arr) {
			count += this.insert(customer);
		}
		return count;
	}

	@Override
	public int delete(Customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from customer " + " WHERE customercode=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomerCode());

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
	public int deleteAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer customer : arr) {
			count += this.delete(customer);
		}
		return count;
	}

	@Override
	public int update(Customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET " + " customerloginname=?" + ", password=?" + ", customername=?" + ", sex=?"
					+ ", address=?" + ", deliveryaddress=?" + ", purchaseaddress=?" + ", dateofbirth=?" + ", phonenumber=?"
					+ ", email=?" + ", signupnewsletter=?" + " WHERE customercode=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomerCode());
			st.setString(2, t.getCustomerLoginName());
			st.setString(3, t.getPassword());
			st.setString(4, t.getCustomerName());
			st.setString(5, t.getSex());
			st.setString(6, t.getAddress());
			st.setString(7, t.getDeliveryAddress());
			st.setString(8, t.getPurchaseAddress());
			st.setDate(9, (Date) t.getDateOfBirth());
			st.setString(10, t.getPhoneNumber());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.isSignUpNewsletter());

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
	
	
	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean result = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE tenDangNhap=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				result = true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
