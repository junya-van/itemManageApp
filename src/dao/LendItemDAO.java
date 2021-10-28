package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * アイテム貸出DAOクラス
 */
public class LendItemDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してアイテム貸出リストに貸出するアイテムを登録する
	 * @param itemId 貸出するアイテムID
	 * @param to_who 貸出相手
	 * @param lend_quantity 貸出数
	 * @return 登録件数
	 */
	public int insertLendItem(int itemId, String to_who, int lend_quantity) {

		int count = 0;

		try {

			con = getConnection();

			String sql = "INSERT INTO lendingList(item_id, lend_quantity, to_who, lent_at) VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setInt(2, lend_quantity);
			ps.setString(3, to_who);
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
	 * コネクションを解除
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
