package top.dm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import top.dm.entity.User;

public class UserDao {
	private static final UserDao LOGIN_DAO = new UserDao();

	private UserDao() {

	}

	public static UserDao getLoginDao() {
		return LOGIN_DAO;
	}

	/**
	 * 根据用户名密码查找用户实体
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 如果存在返回{@link User} 否则返回<code>null</code>
	 * @throws SQLException
	 *             SQLException
	 */
	public User findUser(String username, String password) throws SQLException {
		String[] p = { username, password };
		ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL("select * from [user] where username=? and password=?",
				p, DaoUtils.getConn());
		if (res.next() == false) {
			return null;
		}
		String id = res.getString("id");
		String name = res.getString("username");
		String pwd = res.getString("password");
		User user = new User();
		user.setId(id);
		user.setUsername(name);
		user.setPassword(pwd);
		return user;
	}

	/**
	 * 添加用户
	 * @param user 用户实体
	 * @return 添加是否成功
	 */
	public boolean addUser(User user) {
		String[] p = { user.getId(), user.getUsername(), user.getPassword() };
		int i = DaoUtils.getDaoUtils().executeUpdateSQL("insert into [user] values(?,?,?)", p, DaoUtils.getConn());
		return i != 0;
	}
}
