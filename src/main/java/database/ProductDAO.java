package database;

import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	ArrayList <Product> products = new ArrayList<Product>();
	
	public ArrayList<Product> selectAll() {
		return products;
	}
	
	public Product selectById(String id) {
		for (Product product : products) {
			if(product.getProductCode().equals(id)) {
				return product;
			}
		}
		return null;
	}
	
	public int insert(Product product) {
		Product checkExist = this.selectById(product.getProductCode());
		if(checkExist == null) {
			products.add(product);
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<Product> list) {
		int count = 0;
		for (Product product : list) {
			count += this.insert(product);
			return 1;
		}
		return 0;
	}
	
	public int delete(Product product) {
		Product kiemTraTonTai = this.selectById(product.getProductCode());
		if (kiemTraTonTai != null) {
			products.remove(kiemTraTonTai);
			return 1;
		}
		return 0;
	}

	public int update(Product product) {
		Product checkExist = this.selectById(product.getProductCode());
		if (checkExist != null) {
			products.remove(checkExist);
			products.add(product);
			return 1;
		}
		return 0;

	}
}
