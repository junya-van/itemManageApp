package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.ItemBeans;

/**
 * アイテム登録DAOクラス
 */
public class ItemInsertDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

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

			getConnection();

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
