package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * アイテム名部分一致検索DAOクラス
 */
public class SearchItemNameDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * データベース接続してアイテム名を検索(文字列の部分一致検索)
	 * @param userId ユーザID
	 * @param searchName 部分一致検索に使うアイテム名(文字列)
	 * @return 合致したアイテム名(文字列群)、合致しなければ要素0のリストを返却
	 */
	public List<String> selectItemName(String userId, String searchName) {

		List<String> list = new ArrayList<>();

		try {

			con = GetConnection.getConnection();

			String sql = "SELECT item_name FROM item WHERE item_name LIKE \'%" + searchName + "%\' AND user_id =" + userId;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				list.add(rs.getString("item_name"));

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

			if(rs != null) {

				rs.close();

			}

		} catch(SQLException e) {

			e.printStackTrace();

		}

	}

}
