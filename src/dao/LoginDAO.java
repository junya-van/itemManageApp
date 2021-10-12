package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBeans;

/**
 * ログインDAOクラス
 */
public class LoginDAO {

	// データベース接続に使用する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/item_manage";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * データベース接続してユーザ情報を取得
	 * @param userId ユーザID
	 * @param pass パスワード
	 * @return ユーザ情報(取得失敗したらnullを返す)
	 */
	public UserBeans selectUser(String userId, String pass) {

		UserBeans beans = null;

		try {
			con = getConnection();

			String sql = "SELECT * FROM user WHERE user_id = ? AND pass = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			if(rs.next()) {

				String name = rs.getString("name");

				beans = new UserBeans(userId, pass, name);

			}

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return beans;

	}

	/**
	 * データベース接続する
	 * @return Connection
	 */
	public Connection getConnection() {

		try {

			Class.forName(JDBC_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		}

		return con;

	}

	/**
	 * コネクションを解除する
	 */
	public void close() {

		try {

			if(con != null) {

				con.close();

			}

			if(rs != null) {

				rs.close();

			}

			if(rs != null) {

				rs.close();

			}

		} catch(SQLException e) {

			e.printStackTrace();

		}

	}


}
