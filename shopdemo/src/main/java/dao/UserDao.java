package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.User;
import utils.DataSourceUtils;

public class UserDao {
//	`user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
//	  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
//	  `user_password` varchar(32) DEFAULT NULL COMMENT '用户密码',
//	  `user_phone` varchar(255) DEFAULT NULL COMMENT '电话',
//	  `user_address` varchar(255) DEFAULT NULL COMMENT '地址',
//	  `user_sex` varchar(255) DEFAULT NULL COMMENT '性别',
//	  `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
//	  `user_nickName` varchar(255) DEFAULT NULL COMMENT '昵称',
//	  `user_birthday` date DEFAULT NULL COMMENT '生日',
//	  `user_code` varchar(255) DEFAULT NULL COMMENT '激活码',
//	  `user_state` int(10) DEFAULT NULL COMMENT '激活状态',
	public int register(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
		int row = runner.update(sql, user.getId(),user.getName(),user.getPassword(),
				user.getPhone(),user.getAddress(),user.getSex(),user.getEmail(),user.getNickName(),
				user.getBirthday(),user.getCode(),user.getState());
		return row;
	}

	public User find(String nickName, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where user_nickName = ? and user_password = ?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),nickName,password);
		return user;
	}

}
