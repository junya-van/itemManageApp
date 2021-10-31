package model;

import dao.UserInsertDAO;

/**
 * ユーザ情報登録を担当するBOクラス
 */
public class UserInsertLogic {

	/**
	 * DAOクラスのメソッドを使ってユーザ情報を登録
	 * @param beans ユーザ情報
	 * @return 登録件数
	 */
	public int execute(UserBeans beans) {

		UserInsertDAO dao = new UserInsertDAO();
		int count = dao.insertUser(beans);
		return count;

	}

}
