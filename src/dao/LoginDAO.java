package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBeans;

/**
 * ログインDAOクラス
 */
public class LoginDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * データベース接続してユーザ情報を取得
	 * @param userId ユーザID
	 * @param pass パスワード
	 * @return ユーザ情報(取得失敗したらnullを返す)
	 */
	public UserBeans selectUser(String userId, String pass) {

		UserBeans beans = null;

		try {
			con = GetConnection.getConnection();

			String sql = "SELECT * FROM user WHERE user_id = ? AND pass = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			if(rs.next()) {

				String name = rs.getString("name");

				beans = new UserBeans(userId, pass, name);

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

			if(rs != null) {

				rs.close();

			}

			if(rs != null) {

				rs.close();

			}

		} catch(SQLException e) {

			e.printStackTrace();

		}

	}


}
