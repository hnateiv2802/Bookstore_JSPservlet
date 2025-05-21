package database;

import java.util.ArrayList;

import model.Author;

public class AuthorDAO {
	private ArrayList<Author> data = new ArrayList<Author>();
	
	public ArrayList<Author> selectAll() {
		return data;
	}
	
	public Author selectById(String id) {
		for(Author author : data) {
			if(author.equals(id)) {
				return author;
			}
		}
		return null;
	}
	
	public int insert(Author author) {
		Author checkExist = selectById(author.getAuthorCode());
		if(checkExist == null) {
			data.add(author);
			return 1;
		} 
		else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<Author> listAuthor) {
		int count = 0;
		for (Author author : listAuthor) {
			count += this.insert(author);
		}
		return count;
	}
	
	public int delete(Author author) {
		Author checkExist = selectById(author.getAuthorCode());
		if(checkExist != null) {
			data.remove(author);
			return 1;
		} 
		else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<Author> list) {
		int count = 0;
		for (Author author : list) {
			count += this.delete(author);
		}
		return count;
	}
	
	public int update(Author author) {
		Author checkExist = selectById(author.getAuthorCode());
		if(checkExist != null) {
			data.remove(author);
			data.add(author);
			return 1;
		} 
		else {
			return 0;
		}
	}
}
