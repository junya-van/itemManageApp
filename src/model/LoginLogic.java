package model;

import dao.LoginDAO;

/**
 * ログインBOクラス
 */
public class LoginLogic {

	/**
	 * DAOクラスのメソッドを使ってユーザ情報を取得(失敗したらnullを取得)
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
