package model;

import dao.ItemEditDAO;

/**
 * アイテム編集を担当するBOクラス
 */
public class ItemEditLogic {

	/**
	 * DAOクラスのメソッドを使ってアイテム情報を編集(更新)
	 * @param beans アイテム情報
	 * @return 更新件数
	 */
	public int execute(ItemBeans beans) {

		ItemEditDAO dao = new ItemEditDAO();
		int count = dao.updateItem(beans);

		return count;

	}

}
