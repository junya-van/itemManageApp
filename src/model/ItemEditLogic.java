package model;

import dao.ItemDAO;

/**
 * アイテム編集を担当するBOクラス
 */
public class ItemEditLogic {

	/**
	 * アイテム情報を編集(更新)
	 * @param beans アイテム情報
	 * @return 更新件数
	 */
	public int execute(ItemBeans beans) {

		ItemDAO dao = new ItemDAO();
		int count = dao.updateItem(beans);

		return count;

	}

}
