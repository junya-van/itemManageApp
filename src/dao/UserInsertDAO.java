package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.UserBeans;

/**
 * ユーザ情報登録DAOクラス
 */
public class UserInsertDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してユーザ情報を登録する
	 * @param beans ユーザ情報
	 * @return 登録件数
	 */
	public int insertUser(UserBeans beans) {

		int count = 0;

		try {

			con = getConnection();

			String sql = "INSERT INTO user VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, beans.getUserId());
			ps.setString(2, beans.getPass());
			ps.setString(3, beans.getName());
			ps.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			count = ps.executeUpdate();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return count;

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

			if(ps != null) {

				ps.close();

			}

		} catch(SQLException e) {

			e.printStackTrace();

		}

	}

}
