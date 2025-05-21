package database;

import java.util.ArrayList;

import model.Category;

public class CategoryDAO {
	ArrayList<Category> data = new ArrayList<Category>();
	public ArrayList<Category> selectAll() {
		return data;
	}

	public Category selectById(String Id) {
		for (Category category : data) {
			if (category.getCategoryCode().compareTo(Id) == 0) {
				return category;
			}
		}
		return null;
	}

	public int insert(Category category) {
		Category check = this.selectById(category.getCategoryCode());
		if (check == null) {
			data.add(category);
			return 1;
		}
		return 0;
	}

	public int insertAll(ArrayList<Category> list) {
		int dem = 0;
		for (Category category : list) {
			if (selectById(category.getCategoryCode()) == null) {
				dem += this.insert(category);
			}
		}
		return dem;
	}

	public int delete(Category category) {
		Category check = this.selectById(category.getCategoryCode());
		if (check != null) {
			data.remove(category);
			return 1;
		}
		return 0;
	}

	public int deleteAll(ArrayList<Category> list) {
		int dem = 0;
		for (Category category : list) {
			Category check = this.selectById(category.getCategoryCode());
			if (check != null) {
				dem += this.delete(category);
			}
		}
		return dem;
	}

	public int update(Category category) {
		Category check = this.selectById(category.getCategoryCode());
		if (check != null) {
			data.remove(check);
			data.add(category);// add() not indexof()
			return 1;
		}
		return 0;
	}
}
