package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;

public class ProductService {

	public List<Product> findTop() {
		ProductDao productDao = new ProductDao();
		List<Product> topProduct = null;
		try {
			topProduct = productDao.findTop();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topProduct;
	}

}
