package model;

import java.util.List;

import dao.LendingListDAO;

/**
 * アイテム貸出リスト取得を担当するBOクラス
 */
public class LendingListLogic {

	/**
	 * DAOクラスのメソッドを使ってアイテム貸出リストを取得
	 * @param userId ユーザID
	 * @return アイテム貸出リスト
	 */
	public List<LendingItemBeans> execute(String userId) {

		LendingListDAO dao = new LendingListDAO();
		List<LendingItemBeans> list = dao.selectLendingItem(userId);
		return list;

	}

}
