package model;

import dao.LendItemDAO;

/**
 * アイテム返却処理を担当するBOクラス
 */
public class ReturnedItemLogic {

	/**
	 * DAOクラスのメソッドを使ってアイテム貸出リストから貸出しているアイテムを削除する
	 * @param lendId 貸出ID
	 * @return 削除件数
	 */
	public int execute(int lendId) {

		LendItemDAO dao = new LendItemDAO();
		int count = dao.deleteLendItem(lendId);
		return count;

	}

}
