package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * アイテム返却DAOクラス
 */
public class ReturnedItemDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してアイテム貸出リストから貸出アイテムを削除する
	 * @param lendId 貸出ID
	 * @return 削除件数
	 */
	public int deleteLendItem(int lendId) {

		int count = 0;

		try {

			con = getConnection();

			String sql = "DELETE FROM lendingList WHERE lend_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, lendId);
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
