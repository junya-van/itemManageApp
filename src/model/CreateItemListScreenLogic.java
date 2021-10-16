package model;

import java.util.List;

import dao.CreateItemListScreenDAO;

/**
 * アイテムリスト画面表示を担当するBOクラス
 */
public class CreateItemListScreenLogic {

	/**
	 * DAOクラスのメソッドを使ってデータベースからログインユーザのアイテム数とアイテムが入ったリストを取得。ページネーションも作成<br>
	 * 取得したアイテム数が1ページに表示できるアイテム数を超えていた場合、ページネーションを作成<br>
	 * ページ数が20ページ以上かどうかでページネーションの表示が変わる(20ページ以上ならば先頭ページへのリンクと末尾ページへのリンクが付加される)<br>
	 * ページネーション作成部分では、ページネーション情報を二次元配列pagerにセットする時、1次元目にはページネーションのリンク(<<と>>も含む)の数(位置)を、<br>
	 * 2次元目にはリンク名(jspでページネーションを作成する際、liタグのclass属性値に指定)、リンク先ページ、表示文字の3要素をセット<br>
	 * @param userId ユーザID
	 * @param info アイテムリスト画面作成の情報
	 */
	public void execute(String userId, ItemListScreenInfo info) {

		String searchWord = "%" + info.getSearchWord() + "%";	// SQL文でLIKE文を使うため、抽出ワードに%を足す

		CreateItemListScreenDAO dao = new CreateItemListScreenDAO();

		int total = dao.getCount(userId, searchWord);
		info.setTotal(total);

		List<ItemBeans> list = dao.selectItem(userId, info.getLIMIT(), (info.getPageNo() - 1) * info.getLIMIT(), searchWord);
		info.setList(list);

		// ページネーション作成
		if(total > info.getLIMIT()) {

			int pageCount = total % info.getLIMIT() == 0 ? total / info.getLIMIT() : total / info.getLIMIT() + 1;

			String[][] pager;

			if(pageCount < 20) {

				pager = new String[pageCount][];
				for(int i = 0; i < pageCount; i++) {

					pager[i] = new String[] {info.getPageNo() == i + 1 ? "active" : "", i + 1 + "", i + 1 + ""};

				}

			} else {

				// 現在のページ番号の前後にリンク(最大5件)を設定
				int before = Math.min(info.getPageNo() - 1, 5);
				int after = Math.min(pageCount - info.getPageNo(), 5);
				int len = 1 + before + 1 + after + 1;

				pager = new String[len][];

				// 先頭ページへのリンク
				pager[0] = new String[] {info.getPageNo() == 1 ? "disable" : "", 1 + "", "<<"};

				for(int i = 1, page = info.getPageNo() - before; i < len - 1; i++, page++) {

					pager[i] = new String[] {page == info.getPageNo() ? "active" : "", page + "", page + ""};

				}

				// 末尾ページへのリンク
				pager[len - 1] = new String[] {info.getPageNo() == pageCount ? "disable" : "", pageCount + "", ">>"};

			}

			info.setPager(pager);

		}

	}

}
