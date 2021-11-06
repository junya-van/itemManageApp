package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * アイテム返却DAOクラス
 */
public class ReturnedItemDAO {

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
