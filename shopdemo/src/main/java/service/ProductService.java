package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Category;
import domain.PageBean;
import domain.Product;

public class ProductService {

	// 准备最新商品
	public List<Product> findTop() {
		ProductDao dao = new ProductDao();
		List<Product> topProduct = null;
		try {
			topProduct = dao.findTop();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topProduct;
	}

	// 准备商品分类
	public List<Category> findAllCategory() {
		ProductDao dao = new ProductDao();
		List<Category> category = null;
		try {
			category = dao.finAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return category;
	}

	public PageBean<Product> findProductListByPage(String cid, int currentPage, int currentCount) {
		ProductDao dao = new ProductDao();

		// 封装pageBean
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;

		try {
			totalCount = dao.getCount(cid);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);

		int totalPage = totalCount / currentCount + 1;
		pageBean.setTotalPage(totalPage);

		int index = (currentPage - 1) * currentCount;

		List<Product> productList = null;
		try {
			productList = dao.findProductListByPage(cid, index, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pageBean.setList(productList);
		return pageBean;
	}

	// 根据商品id查询商品详细信息
	public Product findProductByProductId(String product_id) {
		ProductDao dao = new ProductDao();
		Product product = null;
		try {
			product = dao.findProductByProductId(product_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
