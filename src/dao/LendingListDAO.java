package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LendingItemBeans;

/**
 * アイテム貸出リスト取得DAOクラス
 */
public class LendingListDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 現在貸出しているアイテムのリストを取得
	 * @param userId ユーザID
	 * @return 貸出リスト
	 */
	public List<LendingItemBeans> selectLendingItem(String userId) {

		List<LendingItemBeans> list = new ArrayList<>();;

		try {

			con = getConnection();

			String sql = "SELECT item.item_name, lendingList.lend_id, lendingList.item_id, lendingList.lend_quantity, lendingList.to_who, lendingList.lent_at FROM lendingList"
					+ " JOIN item ON lendingList.item_id = item.item_id"
					+ " WHERE item.user_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();

			while(rs.next()) {

				LendingItemBeans beans = new LendingItemBeans();
				beans.setLendId(rs.getInt("lend_id"));
				beans.setItemId(rs.getInt("item_id"));
				beans.setItemName(rs.getString("item_name"));
				beans.setLend_quantity(rs.getInt("lend_quantity"));
				beans.setTo_who(rs.getString("to_who"));
				beans.setLent_at(rs.getDate("lent_at").toLocalDate());

				list.add(beans);

			}

		} catch(SQLException e) {

				e.printStackTrace();

		} finally {

				close();

		}

		return list;

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

			if(rs != null) {

				rs.close();

			}

		} catch(SQLException e) {

			e.printStackTrace();

		}

	}


}
