package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.ItemBeans;

/**
 * アイテム登録DAOクラス
 */
public class ItemInsertDAO {

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してアイテムを登録
	 * @param userId ユーザID
	 * @param beans アイテム情報
	 * @return 登録件数
	 */
	public int insertItem(String userId, ItemBeans beans) {

		int result = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "INSERT INTO item(user_id, item_name, product, jan, genre_id, quantity, imgname, created_at, updated_at)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, beans.getItemName());
			ps.setString(3, beans.getProduct());
			ps.setString(4, beans.getJan());
			ps.setInt(5, beans.getGenreId());
			ps.setInt(6,  beans.getQuantity());
			ps.setString(7, beans.getImgName());
			ps.setDate(8, new Date(Calendar.getInstance().getTimeInMillis()));
			ps.setDate(9, new Date(Calendar.getInstance().getTimeInMillis()));

			result = ps.executeUpdate();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return result;

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
