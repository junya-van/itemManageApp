package model;

import dao.ItemDAO;

/**
 * アイテム登録処理を担当するBOクラス
 */
public class ItemInsertLogic {

	/**
	 * アイテムを登録する
	 * @param userId ユーザID
	 * @param beans アイテム情報
	 * @return 登録件数
	 */
	public int execute(String userId, ItemBeans beans) {

		ItemDAO dao = new ItemDAO();
		int count = dao.insertItem(userId, beans);

		return count;

	}

}
