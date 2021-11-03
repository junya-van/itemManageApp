package model;

import java.util.List;

import dao.CreateItemListScreenDAO;

/**
 * アイテムリスト画面表示を担当するBOクラス
 */
public class CreateItemListScreenLogic {

	/**
	 * DAOクラスのメソッドを使ってデータベースからログインユーザのアイテム数とアイテムが入ったリストを取得。<br>
	 * 取得したアイテム数が1ページに表示できるアイテム数を超えていた場合、ページネーション作成の為の情報もセット<br>
	 * @param userId ユーザID
	 * @param info アイテムリスト画面作成の情報
	 */
	public void execute(String userId, ItemListScreenInfo info) {

		CreateItemListScreenDAO dao = new CreateItemListScreenDAO();

		int total = dao.getCount(userId);
		info.setTotal(total);

		List<ItemBeans> list = dao.selectItem(userId, info.getLIMIT(), (info.getPageNo() - 1) * info.getLIMIT());
		info.setList(list);

		if(total > info.getLIMIT()) {

			PaginationLogic.paginationInfoSet(info);

		}

	}

}
