package model;

import dao.LoginDAO;

/**
 * ログイン処理を担当するBOクラス
 */
public class LoginLogic {

	/**
	 * ユーザ情報を取得(失敗したらnullを取得)
	 * @param userId ユーザID
	 * @param pass パスワード
	 * @return ユーザ情報
	 */
	public UserBeans execute(String userId, String pass) {

		LoginDAO dao = new LoginDAO();
		UserBeans beans = dao.selectUser(userId, pass);

		return beans;

	}

}
