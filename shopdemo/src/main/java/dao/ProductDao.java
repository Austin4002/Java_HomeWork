package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Product;
import utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findTop() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top 6 * from product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

}
