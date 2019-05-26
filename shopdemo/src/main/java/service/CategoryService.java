package service;

import java.sql.SQLException;
import java.util.List;

import dao.CategoryDao;
import domain.Category;

public class CategoryService {

	public List<Category> findAll() {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> list = null;
		try {
			list = categoryDao.finAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
