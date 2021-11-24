package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.UserBeans;

/**
 * ユーザ情報登録DAOクラス
 */
public class UserInsertDAO {

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してユーザ情報を登録する
	 * @param beans ユーザ情報
	 * @return 登録件数
	 */
	public int insertUser(UserBeans beans) {

		int count = 0;

		try {

			con = GetConnection.getConnection();

			String sql = "INSERT INTO user VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, beans.getUserId());
			ps.setString(2, beans.getPass());
			ps.setString(3, beans.getName());
			ps.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
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
