package model;

import dao.ItemDAO;
import dao.LendItemDAO;

/**
 * アイテム取得を担当するBOクラス
 */
public class ItemLogic {

	/**
	 * DAOクラスのメソッドを使ってアイテムIDを基にアイテムを取得.<br>
	 * 現在貸出している数も取得
	 * @param itemId アイテムID
	 * @return アイテム情報
	 */
	public ItemBeans execute(int itemId) {

		ItemDAO dao = new ItemDAO();
		ItemBeans beans = dao.selectItem(itemId);

		if(beans != null) {

			LendItemDAO lend_dao = new LendItemDAO();
			int count = lend_dao.lendingItemCount(itemId);
			beans.setLend_quantity(count);

		}

		return beans;

	}

}
