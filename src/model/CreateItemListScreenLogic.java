package model;

import java.util.List;

import dao.CreateItemListScreenDAO;

/**
 * ログイン後、全件検索リンク、結果画面のリンクを踏んだ後のアイテムリスト画面表示に関する情報のセットを担当するBOクラス
 */
public class CreateItemListScreenLogic {

	/**
	 * ログインユーザのアイテム数(全件分)とアイテムが入ったリスト(全件分)を取得してItemListScreenInfoのフィールドにセット。<br>
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
