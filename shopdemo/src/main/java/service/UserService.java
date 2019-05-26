package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;

public class UserService {

	public boolean register(User user) {
		UserDao dao = new UserDao();
		int row = 0;
		try {
			row = dao.register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}

	public User login(User user) {
		UserDao dao = new UserDao();
		User u = null;
		try {
			u = dao.find(user.getNickName(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
