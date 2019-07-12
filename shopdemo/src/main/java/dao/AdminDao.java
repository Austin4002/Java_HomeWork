package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import domain.Category;
import domain.Order;
import domain.Product;
import utils.DataSourceUtils;

public class AdminDao {

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		return runner.query(sql, new BeanListHandler<Category>(Category.class));
	}

	public void saveProduct(Product product) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into product values(?,?,?,?,?,?,?,?)";
		runner.update(sql, product.getProduct_id(),product.getProduct_name(),product.getProduct_price(),
				new Date(),product.getProduct_image(),product.getProduct_attribute(),
				product.getProduct_description(), product.getCid() );
	}

	public List<Order> findAllOrder() throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from `order`";
		return runner.query(sql, new BeanListHandler<Order>(Order.class));
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select p.product_image,p.product_name,p.product_price,i.count,i.subtotal from orderitem i,product p where i.pid=p.product_id and oid=?";
		return runner.query(sql, new MapListHandler(), oid);
	}

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product";
		return runner.query(sql,new BeanListHandler<Product>(Product.class));
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where product_id=?";
		return runner.query(sql,new BeanHandler<Product>(Product.class),pid);
	}

	public Category findCategoryById(String cid) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category where cid=?";
		return runner.query(sql, new BeanHandler<Category>(Category.class),cid);
	}

	public int updateCategory(Category category) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update category set cname = ? where cid=?";
		return runner.update(sql,category.getCname(),category.getCid());
	}

	public void delProductByPid(String pid) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from product where product_id=?";
		runner.update(sql, pid);
	}

	public void delCategoryByPid(String cid) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from category where cid=?";
		runner.update(sql, cid);
	}

	public void addCategory(String cname) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into category (cname) values(?)";
		runner.update(sql, cname);
	}

}
