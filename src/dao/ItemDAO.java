package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ItemBeans;

/**
 * アイテム取得DAOクラス
 */
public class ItemDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * アイテムIDを基にデータベースからアイテムを取得
	 * @param itemId アイテムID
	 * @return アイテム情報
	 */
	public ItemBeans selectItem(int itemId) {

		ItemBeans beans = null;

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT item.item_id, item.item_name, item.product, item.jan, genre.genre_name, item.quantity, item.score, item.imgname, item.created_at, item.updated_at FROM item"
					+ " JOIN genre ON item.genre_id = genre.genre_id"
					+ " WHERE item.item_id = ?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			rs = ps.executeQuery();

			if(rs.next()) {

				beans = new ItemBeans();
				beans.setItemId(rs.getInt("item_id"));
				beans.setItemName(rs.getString("item_name"));
				beans.setProduct(rs.getString("product"));
				beans.setJan(rs.getString("jan"));
				beans.setGenre(rs.getString("genre_name"));
				beans.setQuantity(rs.getInt("quantity"));
				beans.setScore(rs.getInt("score"));
				beans.setImgName(rs.getString("imgname"));
				beans.setCreated_at(rs.getDate("created_at").toLocalDate());
				beans.setUpdated_at(rs.getDate("updated_at").toLocalDate());

			}

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return beans;

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
