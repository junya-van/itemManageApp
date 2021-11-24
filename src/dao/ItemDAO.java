package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import model.ItemBeans;

/**
 * アイテムDAOクラス
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
				beans.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
				beans.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());

			}

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return beans;

	}

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

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return count;

	}

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
			ps.setTimestamp(8, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			ps.setInt(9, beans.getItemId());

			count = ps.executeUpdate();

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return count;

	}

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
			ps.setTimestamp(8, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			ps.setTimestamp(9, new Timestamp(Calendar.getInstance().getTimeInMillis()));

			result = ps.executeUpdate();

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return result;

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
