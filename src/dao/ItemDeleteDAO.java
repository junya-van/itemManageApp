package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * アイテム削除DAOクラス
 */
public class ItemDeleteDAO {

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

			con = GetConnection.getConnection();

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
