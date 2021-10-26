package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * アイテム削除DAOクラス
 */
public class ItemDeleteDAO {

	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続して指定したアイテムIDのアイテムを削除する
	 * @param itemId アイテムID
	 * @return 削除件数
	 */
	public int deleteItem(int itemId) {

		int count = 0;

		try {

			con = getConnection();

			String sql = "DELETE FROM item WHERE item_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
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
