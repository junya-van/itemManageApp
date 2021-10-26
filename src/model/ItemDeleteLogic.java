package model;

import dao.ItemDeleteDAO;

/**
 * アイテム削除を担当するBOクラス
 */
public class ItemDeleteLogic {

	/**
	 * DAOクラスのメソッドを使って指定したアイテムIDのアイテムを削除
	 * @param itemId アイテムID
	 * @return 削除件数
	 */
	public int execute(int itemId) {

		ItemDeleteDAO dao = new ItemDeleteDAO();
		int count = dao.deleteItem(itemId);

		return count;

	}

}
