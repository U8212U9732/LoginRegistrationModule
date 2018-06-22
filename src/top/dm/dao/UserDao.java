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
	 * �����û�����������û�ʵ��
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return ������ڷ���{@link User} ���򷵻�<code>null</code>
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
	 * ����û�
	 * @param user �û�ʵ��
	 * @return ����Ƿ�ɹ�
	 */
	public boolean addUser(User user) {
		String[] p = { user.getId(), user.getUsername(), user.getPassword() };
		int i = DaoUtils.getDaoUtils().executeUpdateSQL("insert into [user] values(?,?,?)", p, DaoUtils.getConn());
		return i != 0;
	}
}
