package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Author;

public class AuthorDAO implements DAOinteface<Author>{

	private ArrayList<Author> data = new ArrayList<Author>();

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> result = new ArrayList<Author>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM author";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String authorCode = rs.getString("authorcode");
				String authorName = rs.getString("authorname");
				Date dob = rs.getDate("dateofbirth");
				String bio = rs.getString("biography");		
				
				Author author = new Author(authorCode, authorName, dob, bio);
				result.add(author);
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
	public Author selectById(Author t) {
		Author result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM author WHERE authorcode=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAuthorCode());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String authorCode = rs.getString("authorcode");
				String authorName = rs.getString("authorname");
				Date dob = rs.getDate("dateofbirth");
				String bio = rs.getString("biography");
				
				result = new Author(authorCode, authorName, dob, bio);
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
	public int insert(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO author (authorcode, authorname, dateofbirth,biography) "+
					" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAuthorCode());
			st.setString(2, t.getAuthorName());
			st.setDate(3, t.getDateOfBirth());
			st.setString(4, t.getBiography());
			
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
	public int insertAll(ArrayList<Author> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from Author "+
					 " WHERE authorcode=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAuthorCode());
			
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
	public int deleteAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {
			count += this.delete(author);
			
		}
		return count;
	}

	@Override
	public int update(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE author "+
					 " SET " +
					 " authorname=?"+
					 ", dateofbirth=?"+
					 ", biography=?"+
					 " WHERE authorcode=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAuthorName());
			st.setDate(2, t.getDateOfBirth());
			st.setString(3, t.getBiography());
			st.setString(4,	t.getAuthorCode());
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
		AuthorDAO authorDAO = new AuthorDAO();
//		ArrayList<Author> result = authorDAO.selectAll();
//		for (Author author : result) {
//			System.out.println(author.toString());
//		}
//		
//		Author author = authorDAO.selectById(new Author("TG4", "", null, ""));
//		System.out.println(author);
//		author.setBiography("update nothing!");
//		authorDAO.update(author);
//		System.out.println(author);
//		Author author = new Author("TG9", "Donald Trump", new Date(2000-1900, 10, 24), "He is a bussiness");
//		authorDAO.insert(author);
//		authorDAO.delete(author);
	}
}
