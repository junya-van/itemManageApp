package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemBeans;

/**
 * アイテムリスト画面作成DAOクラス
 */
public class CreateItemListScreenDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * データベースからログインユーザのアイテム数を全件取得
	 * @param ユーザID
	 * @return アイテム数
	 */
	public int getCount(String userId) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT COUNT(*) AS total FROM item WHERE user_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();

			if(rs.next()) {

				count = rs.getInt("total");

			}

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
	 * ログインユーザのアイテム数(文字列部分検索をして一致した件数分)をデータベースから取得
	 * @param userId ユーザID
	 * @param searchWord 文字列部分一致検索に使用するワード
	 * @return 一致件数
	 */
	public int getCount(String userId, String searchWord) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT COUNT(*) AS total FROM item WHERE user_id = ? AND item_name LIKE ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, searchWord);
			rs = ps.executeQuery();

			if(rs.next()) {

				count = rs.getInt("total");

			}

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
	 * ログインユーザのアイテム数(指定したジャンルに一致した分)をデータベースから取得
	 * @param userId ユーザID
	 * @param genreId ジャンルID
	 * @return 一致件数
	 */
	public int getCount(String userId, int genreId) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT COUNT(*) AS total FROM item WHERE user_id = ? AND genre_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, genreId);
			rs = ps.executeQuery();

			if(rs.next()) {

				count = rs.getInt("total");

			}

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
	 * ログインユーザのアイテム(全件)をデータベースから降順(更新日を基準)で取得。<br>
	 * ページネーション作成に使用するので<br>
	 * 取得数と取得を開始する位置を指定するLIMITとOFFSETを使う
	 * @param userId ユーザID
	 * @param limit SQL文のLIMITに使用する変数
	 * @param offset SQL文のOFFSETに使用する変数
	 * @return アイテム情報が入ったリスト
	 */
	public List<ItemBeans> selectItem(String userId, int limit, int offset) {

		List<ItemBeans> list = new ArrayList<>();

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT item.item_id, item.item_name, item.product, item.jan, genre.genre_name, item.score, item.imgname FROM item"
					+ " JOIN genre ON item.genre_id = genre.genre_id"
					+ " WHERE item.user_id = ? ORDER BY item.updated_at DESC LIMIT ? OFFSET ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, limit);
			ps.setInt(3, offset);
			rs = ps.executeQuery();

			while(rs.next()) {

				ItemBeans beans = new ItemBeans();

				beans.setItemId(rs.getInt("item_id"));
				beans.setItemName(rs.getString("item_name"));
				beans.setProduct(rs.getString("product"));
				beans.setJan(rs.getString("jan"));
				beans.setGenre(rs.getString("genre_name"));
				beans.setScore(rs.getInt("score"));
				beans.setImgName(rs.getString("imgname"));

				list.add(beans);

			}

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return list;

	}

	/**
	 * ログインユーザのアイテム(文字列部分一致検索で合致した件数分)をデータベースから降順(更新日を基準)で取得
	 * @param userId ユーザID
	 * @param searchWord 文字列部分一致検索に使用するワード
	 * @param limit SQL文のLIMITに使用する変数
	 * @param offset SQL文のOFFSETに使用する変数
	 * @return 一致したアイテムの情報が入ったリスト
	 */
	public List<ItemBeans> selectItem(String userId, String searchWord, int limit, int offset) {

		List<ItemBeans> list = new ArrayList<>();

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT item.item_id, item.item_name, item.product, item.jan, genre.genre_name, item.score, item.imgname FROM item"
					+ " JOIN genre ON item.genre_id = genre.genre_id"
					+ " WHERE item.user_id = ? AND item.item_name LIKE ? ORDER BY item.updated_at DESC LIMIT ? OFFSET ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, searchWord);
			ps.setInt(3, limit);
			ps.setInt(4, offset);
			rs = ps.executeQuery();

			while(rs.next()) {

				ItemBeans beans = new ItemBeans();
				beans.setItemId(rs.getInt("item_id"));
				beans.setItemName(rs.getString("item_name"));
				beans.setProduct(rs.getString("product"));
				beans.setJan(rs.getString("jan"));
				beans.setGenre(rs.getString("genre_name"));
				beans.setScore(rs.getInt("score"));
				beans.setImgName(rs.getString("imgname"));

				list.add(beans);

			}

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return list;

	}

	/**
	 * ログインユーザのアイテム(指定したジャンルに一致した分)をデータベースから取得
	 * @param userId ユーザID
	 * @param genreId ジャンルID
	 * @param limit SQL文のLIMITに使用する変数
	 * @param offset SQL文のOFFSETに使用する変数
	 * @return 一致したアイテムの情報が入ったリスト
	 */
	public List<ItemBeans> selectItem(String userId, int genreId, int limit, int offset) {

		List<ItemBeans> list = new ArrayList<>();

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT item.item_id, item.item_name, item.product, item.jan, genre.genre_name, item.score, item.imgname FROM item"
					+ " JOIN genre ON item.genre_id = genre.genre_id"
					+ " WHERE item.user_id = ? AND item.genre_id = ? ORDER BY updated_at DESC LIMIT ? OFFSET ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, genreId);
			ps.setInt(3, limit);
			ps.setInt(4, offset);
			rs = ps.executeQuery();

			while(rs.next()) {

				ItemBeans beans = new ItemBeans();
				beans.setItemId(rs.getInt("item_id"));
				beans.setItemName(rs.getString("item_name"));
				beans.setProduct(rs.getString("product"));
				beans.setJan(rs.getString("jan"));
				beans.setGenre(rs.getString("genre_name"));
				beans.setScore(rs.getInt("score"));
				beans.setImgName(rs.getString("imgname"));

				list.add(beans);

			}

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return list;

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

