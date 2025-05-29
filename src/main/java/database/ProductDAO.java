package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;
import model.Category;
import model.Product;
import model.Product;

public class ProductDAO implements DAOinteface<Product>{
	private ArrayList<Product> data = new ArrayList<Product>();

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String productCode = rs.getString("productcode");
				String productName = rs.getString("productname");
				String authorCode = rs.getString("authorcode");
				int publication = rs.getInt("publication");
				double importPrice = rs.getDouble("importprice");
				double exportPrice = rs.getDouble("exportprice");
				double sellingPriceProduct = rs.getDouble("sellingpriceproduct");
				int quantity = (int) rs.getDouble("quantity");
				String categoryCode = rs.getString("categorycode");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = new AuthorDAO().selectById(new Author(authorCode, "", null, ""));
				Category category = new CategoryDAO().selectById(new Category(categoryCode, ""));

				Product product = new Product(productCode, productName, author, publication, importPrice, exportPrice, 
											sellingPriceProduct, quantity, category, language, description);
				result.add(product);
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
	public Product selectById(Product t) {
		Product result = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM product WHERE productcode=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProductCode());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String productCode = rs.getString("productcode");
				String productName = rs.getString("productname");
				String authorCode = rs.getString("authorcode");
				int publication = rs.getInt("publication");
				double importPrice = rs.getDouble("importprice");
				double exportPrice = rs.getDouble("exportprice");
				double sellingPriceProduct = rs.getDouble("sellingpriceproduct");
				int quantity = (int) rs.getDouble("quantity");
				String categoryCode = rs.getString("categorycode");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = new AuthorDAO().selectById(new Author(authorCode, "", null, ""));
				Category category = new CategoryDAO().selectById(new Category(categoryCode, ""));

				result = new Product(productCode, productName, author, publication, importPrice, exportPrice, 
										sellingPriceProduct, quantity, category, language, description);
				break;
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insert(Product t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO product (productcode,productname, authorcode, publication,"
					+ " importprice, exportprice, sellingpriceproduct, quantity, categorycode, language, description) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProductCode());
			st.setString(2, t.getProductName());
			st.setString(3, t.getAuthor().getAuthorCode());
			st.setInt(4, t.getPublication());
			st.setDouble(5, t.getImportPrice());
			st.setDouble(6, t.getExportPrice());
			st.setDouble(7, t.getSellingPriceProduct());
			st.setInt(8, t.getQuantity());
			st.setString(9, t.getCategory().getCategoryCode());
			st.setString(10, t.getLanguage());
			st.setString(11, t.getDescription());

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
	public int insertAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product Product : arr) {
			count += this.insert(Product);
		}
		return count;
	}

	@Override
	public int delete(Product t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from product " + " WHERE productcode=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProductCode());

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
	public int deleteAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product SanPham : arr) {
			count += this.delete(SanPham);
		}
		return count;
	}

	@Override
	public int update(Product t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE product " + " SET " + "productname=?, authorcode=?, publication=?, importprice=?, exportprice=?, "
					+ "sellingpriceproduct=?, quantity=?, categorycode=?, language=?, description=?" + " WHERE productcode=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProductCode());
			st.setString(2, t.getProductName());
			st.setString(3, t.getAuthor().getAuthorCode());
			st.setInt(4, t.getPublication());
			st.setDouble(5, t.getImportPrice());
			st.setDouble(6, t.getExportPrice());
			st.setDouble(7, t.getSellingPriceProduct());
			st.setInt(8, t.getQuantity());
			st.setString(9, t.getCategory().getCategoryCode());
			st.setString(10, t.getLanguage());
			st.setString(11, t.getDescription());
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

}
