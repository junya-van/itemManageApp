package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.LendingItemBeans;

/**
 * アイテム貸出返却に関するDAOクラス
 */
public class LendItemDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * データベース接続してアイテム貸出リストに貸出するアイテムを登録する
	 * @param itemId 貸出するアイテムID
	 * @param to_who 貸出相手
	 * @param lend_quantity 貸出数
	 * @return 登録件数
	 */
	public int insertLendingList(int itemId, String to_who, int lend_quantity) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

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
	 * 現在貸出しているアイテムのリストを取得
	 * @param userId ユーザID
	 * @return 貸出リスト
	 */
	public List<LendingItemBeans> selectLendingItem(String userId) {

		List<LendingItemBeans> list = new ArrayList<>();;

		try {

			con = GetConnection.getConnection();

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
	 * データベース接続してアイテム貸出リストから貸出アイテムを削除する
	 * @param lendId 貸出ID
	 * @return 削除件数
	 */
	public int deleteLendItem(int lendId) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

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
	 * 指定したアイテムIDのアイテムの貸出数の合計をデータベースから取得
	 * @param itemId アイテムID
	 * @return 貸出数
	 */
	public int lendingItemCount(int itemId) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT SUM(lend_quantity) AS lend_quantity FROM lendingList WHERE item_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			rs = ps.executeQuery();

			if(rs.next()) {

				count = rs.getInt("lend_quantity");

			}

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return count;

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
