package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.ItemBeans;

/**
 * アイテム編集DAOクラス
 */
public class ItemEditDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

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

			con = getConnection();

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

		} catch(SQLException e) {

			e.printStackTrace();

		}

	}

}
