package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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

	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * ログインユーザのアイテム数を全件データベースから取得
	 * @param ユーザID
	 * @return アイテム数
	 */
	public int getCount(String userId) {

		int count = 0;

		try {

			con = getConnection();

			String sql = "SELECT COUNT(*) AS total FROM item JOIN user ON item.user_id = user.user_id WHERE user.user_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();

			if(rs.next()) {

				count = rs.getInt("total");

			}

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return count;

	}

	/**
	 * ログインユーザのアイテムをデータベースから降順(更新日を基準)で取得。<br>
	 * ページネーション(例えば1ページ目に20件、次のページに20件アイテムを表示)を使用するので、<br>
	 * 取得数と取得を開始する位置を指定するLIMITとOFFSETを使う
	 * @param userId ユーザID
	 * @param limit SQL文のLIMITに使用する変数
	 * @param offset SQL文のOFFSETに使用する変数
	 * @return アイテム情報が入ったリスト
	 */
	public List<ItemBeans> selectItem(String userId, int limit, int offset) {

		List<ItemBeans> list = new ArrayList<>();

		try {

			con = getConnection();

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

				beans.setItemId(rs.getInt("item_id"));	// itemList.jspで編集リンクと各アイテムIDを紐づける為、レコードからアイテムIDを取得してItemBeansインスタンスのフィールドにセットする
				beans.setItemName(rs.getString("item_name"));
				beans.setProduct(rs.getString("product"));
				beans.setJan(rs.getString("jan"));
				beans.setGenre(rs.getString("genre_name"));
				beans.setScore(rs.getInt("score"));
				beans.setImgName(rs.getString("imgname"));

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

