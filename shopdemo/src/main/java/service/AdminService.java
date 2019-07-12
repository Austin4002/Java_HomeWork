package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.AdminDao;
import domain.Category;
import domain.Order;
import domain.Product;

public class AdminService {

	public List<Category> findAllCategory() {
		AdminDao dao=new AdminDao();
		try {
			List<Category> categorieList=dao.findAllCategory();
			return categorieList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveProduct(Product product) {
		AdminDao dao=new AdminDao();
		try {
			dao.saveProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> findAllOrder() {
		AdminDao dao=new AdminDao();
		List<Order> orderList;
		try {
			orderList = dao.findAllOrder();
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) {
		AdminDao dao=new AdminDao();
		try {
			List<Map<String, Object>> orderList=dao.findOrderInfoByOid(oid);
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> findAllProduct() {
		AdminDao dao=new AdminDao();
		List<Product> productList =null;
		try {
			productList = dao.findAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public Product findProductByPid(String pid) {
		AdminDao dao=new AdminDao();
		Product product = null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public Category findCategoryById(String cid) {
		AdminDao dao=new AdminDao();
		Category category = null;
		try {
			category = dao.findCategoryById(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	public int updateCategory(Category category) {
		AdminDao dao=new AdminDao();
		int i = 0;
		try {
			i = dao.updateCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void delProductByPid(String pid) {
		AdminDao dao=new AdminDao();
		try {
			dao.delProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delCategoryByPid(String cid) {
		AdminDao dao=new AdminDao();
		try {
			dao.delCategoryByPid(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void addCategory(String cname) {
		AdminDao dao=new AdminDao();
		try {
			dao.addCategory(cname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
