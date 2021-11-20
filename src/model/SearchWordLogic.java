package model;

import java.util.List;

import dao.CreateItemListScreenDAO;

/**
 * 文字列部分一致検索後のアイテムリスト画面作成の為の情報セットを担当するBOクラス
 */
public class SearchWordLogic {

	/**
	 * 一致したアイテム数と一致したアイテムのリストを取得してItemListScreenInfoのフィールドにセット<br>
	 * 取得したアイテム数が1ページに表示できるアイテム数を超えていた場合、ページネーション作成の為の情報もセット
	 * @param userId ユーザID
	 * @param info アイテムリスト画面作成の情報
	 */
	public void execute(String userId, ItemListScreenInfo info) {

		String searchWord = "%" + info.getSearchWord() + "%";

		CreateItemListScreenDAO dao = new CreateItemListScreenDAO();

		int total = dao.getCount(userId, searchWord);
		info.setTotal(total);

		List<ItemBeans> list = dao.selectItem(userId, searchWord, info.getLIMIT(), (info.getPageNo() - 1) * info.getLIMIT());
		info.setList(list);

		if(total > info.getLIMIT()) {

			PaginationLogic.paginationInfoSet(info);

		}

	}

}
