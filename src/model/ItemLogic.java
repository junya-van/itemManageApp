package model;

import dao.ItemDAO;

/**
 * アイテム取得を担当するBOクラス
 */
public class ItemLogic {

	/**
	 * DAOクラスのメソッドを使ってアイテムIDを基にアイテムを取得
	 * @param itemId アイテムID
	 * @return アイテム情報
	 */
	public ItemBeans execute(int itemId) {

		ItemDAO dao = new ItemDAO();
		ItemBeans beans = dao.selectItem(itemId);
		return beans;

	}

}
