package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Category;
import domain.Product;
import utils.DataSourceUtils;

public class ProductDao {

	// 查询最新的4件商品
	public List<Product> findTop() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by product_date desc limit ?,?";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class), 0, 4);
		return list;
	}

	// 根据类别查询商品
	public List<Product> findProductListByPage(String cid, int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid = ? limit ?,?";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class), cid, index, currentCount);
		return list;
	}

	// 获得所有的商品分类
	public List<Category> finAll() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return list;
	}

	// 根据cid获得商品总条数
	public int getCount(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid = ?";
		Long count = (Long) runner.query(sql, new ScalarHandler(), cid);
		return count.intValue();
	}

	// 根据商品id获得商品详细信息
	public Product findProductByProductId(String product_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where product_id = ?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), product_id);
		return product;
	}

}
