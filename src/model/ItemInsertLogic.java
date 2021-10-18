package model;

import dao.ItemInsertDAO;

/**
 * アイテム登録処理を担当するBOクラス
 */
public class ItemInsertLogic {

	/**
	 * DAOクラスのメソッドを実行してアイテムを登録する
	 * @param userId ユーザID
	 * @param beans アイテム情報
	 * @return 登録件数
	 */
	public int execute(String userId, ItemBeans beans) {

		ItemInsertDAO dao = new ItemInsertDAO();
		int count = dao.insertItem(userId, beans);

		return count;

	}

}
