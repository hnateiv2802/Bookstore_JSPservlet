package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;
import model.Category;

public class CategoryDAO implements DAOinteface<Category> {
	private ArrayList<Category> data = new ArrayList<Category>();

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> result = new ArrayList<Category>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String categoryCode = rs.getString("categorycode");
				String categoryName = rs.getString("categoryname");

				Category cate = new Category(categoryCode, categoryName);
				result.add(cate);
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
	public Category selectById(Category t) {
		Category result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category WHERE categorycode=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCategoryCode());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String categoryCode = rs.getString("categorycode");
				String categoryName = rs.getString("categoryname");

				result = new Category(categoryCode, categoryName);
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
	public int insert(Category t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO category (categorycode, categoryname) "+
					" VALUES (?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCategoryCode());
			st.setString(2, t.getCategoryName());
			
			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ result+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertAll(ArrayList<Category> arr) {
		int count = 0;
		for (Category theLoai : arr) {
			count+=this.insert(theLoai);
		}
		return count;
	}

	@Override
	public int delete(Category t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from category "+
					 " WHERE categorycode=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCategoryCode());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			result = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ result+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteAll(ArrayList<Category> arr) {
		int count = 0;
		for (Category TheLoai : arr) {
			count += this.delete(TheLoai);
		}
		return count;
	}

	@Override
	public int update(Category t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE category "+
					 " SET " +
					 " categoryname=?"+
					 " WHERE categorycode=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCategoryName());
			st.setString(2, t.getCategoryCode());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ result+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public static void main(String[] args) {
		CategoryDAO cate = new CategoryDAO();
//		ArrayList<Category> list = cate.selectAll();
//		for (Category category : list) {
//			System.out.println(category.toString());
//		}
		
		Category newcate = cate.selectById(new Category("KH", null));
		System.out.println(newcate);
//		insert:
//		Category catenew = new Category("DL", "địa lý");
//		cate.insert(catenew);
	}

}
