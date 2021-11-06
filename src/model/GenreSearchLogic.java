package model;

import java.util.List;

import dao.CreateItemListScreenDAO;

/**
 * ジャンル検索後のアイテムリスト画面表示に関する情報のセットを担当するBOクラス
 */
public class GenreSearchLogic {

	/**
	 * DAOクラスのメソッドを使って特定のジャンルのアイテム数とアイテム情報を取得.<br>
	 * 取得したアイテム数が1ページに表示できるアイテム数を超えていた場合ページネーション作成の為の情報をセット
	 * @param userId ユーザID
	 * @param info アイテムリスト画面作成の情報
	 */
	public void execute(String userId, ItemListScreenInfo info) {

		CreateItemListScreenDAO dao = new CreateItemListScreenDAO();

		int total = dao.getCount(userId, info.getGenreId());
		info.setTotal(total);

		List<ItemBeans> beans = dao.selectItem(userId, info.getGenreId(), info.getLIMIT(), (info.getPageNo() - 1) * info.getLIMIT());
		info.setList(beans);

		if(total > info.getLIMIT()) {

			PaginationLogic.paginationInfoSet(info);

		}

	}

}
