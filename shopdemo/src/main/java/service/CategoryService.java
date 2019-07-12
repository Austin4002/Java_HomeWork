package service;

import java.sql.SQLException;
import java.util.List;

import dao.CategoryDao;
import domain.Category;

public class CategoryService {
	
	public List<Category> findAll() {
		CategoryDao categoryDao=new CategoryDao();
		List<Category> list=null;
		try {
			list=categoryDao.findAll();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

}
