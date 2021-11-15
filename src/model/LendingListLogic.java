package model;

import java.util.List;

import dao.LendItemDAO;

/**
 * アイテム貸出リスト取得を担当するBOクラス
 */
public class LendingListLogic {

	/**
	 * アイテム貸出リストを取得
	 * @param userId ユーザID
	 * @return アイテム貸出リスト
	 */
	public List<LendingItemBeans> execute(String userId) {

		LendItemDAO dao = new LendItemDAO();
		List<LendingItemBeans> list = dao.selectLendingItem(userId);
		return list;

	}

}
