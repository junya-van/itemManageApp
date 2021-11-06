package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.ItemBeans;

/**
 * アイテム編集DAOクラス
 */
public class ItemEditDAO {

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してアイテム情報を編集(更新)する
	 * @param beans アイテム情報
	 * @return 更新件数
	 */
	public int updateItem(ItemBeans beans) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "UPDATE item SET item_name=?, product=?, jan=?, genre_id=?, quantity=?, score=?, imgname=?, updated_at=? WHERE item_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, beans.getItemName());
			ps.setString(2, beans.getProduct());
			ps.setString(3, beans.getJan());
			ps.setInt(4, beans.getGenreId());
			ps.setInt(5, beans.getQuantity());
			ps.setInt(6, beans.getScore());
			ps.setString(7, beans.getImgName());
			ps.setDate(8, new Date(Calendar.getInstance().getTimeInMillis()));
			ps.setInt(9, beans.getItemId());

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
