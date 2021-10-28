package model;

import dao.LendItemDAO;

/**
 * アイテム貸出を担当するBOクラス
 */
public class LendItemLogic {

	/**
	 * DAOクラスのメソッドを使ってアイテム貸出リストに貸出するアイテムを登録する
	 * @param itemId 貸出するアイテムID
	 * @param to_who 貸出相手
	 * @param lend_quantity 貸出数
	 * @return 登録件数
	 */
	public int execute(int itemId, String to_who, int lend_quantity) {

		LendItemDAO dao = new LendItemDAO();
		int count = dao.insertLendItem(itemId, to_who, lend_quantity);

		return count;

	}

}
