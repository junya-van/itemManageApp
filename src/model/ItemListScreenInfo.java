package model;

import java.util.List;

/**
 * アイテムリスト画面の情報を格納するBeansクラス
 */
public class ItemListScreenInfo implements java.io.Serializable {

	private List<ItemBeans> list;	// アイテム情報を格納するリスト
	private int pageNo;			// 現在のページ番号
	private int total;				// アイテムの件数
	private final int LIMIT = 20;	// 1ページに表示するアイテム数(今回は20件まで)
	private String[][] pager;		// ページネーション作成の為の情報
	private String searchWord;		// 抽出ワード

	/**
	 * アイテム情報が入ったリストを取得
	 * @return アイテム情報が入ったリスト
	 */
	public List<ItemBeans> getList() {

		return list;

	}

	/**
	 * アイテム情報を格納するリストを設定
	 * @param list アイテム情報を格納するリスト
	 */
	public void setList(List<ItemBeans> list) {

		this.list = list;

	}

	/**
	 * 現在のページ番号を取得
	 * @return 現在のページ番号
	 */
	public int getPageNo() {

		return pageNo;

	}

	/**
	 * 現在のページ番号を設定
	 * @param pageNo 現在のページ番号
	 */
	public void setPageNo(int pageNo) {

		this.pageNo = pageNo;

	}

	/**
	 * アイテムの件数を取得
	 * @return アイテムの件数
	 */
	public int getTotal() {

		return total;

	}

	/**
	 * アイテムの件数を設定
	 * @param total アイテムの件数
	 */
	public void setTotal(int total) {

		this.total = total;

	}

	/**
	 * 1ページに表示できるアイテム数を取得
	 * @return アイテム数
	 */
	public int getLIMIT() {

		return LIMIT;

	}

	/**
	 * ページネーション作成の為の情報が入った配列を取得
	 * @return ページネーションの情報が入った二次元配列
	 */
	public String[][] getPager() {

		return pager;

	}

	/**
	 * ページネーション作成の為の情報を格納する配列を設定
	 * @param pager ページネーションの情報を格納する二次元配列
	 */
	public void setPager(String[][] pager) {

		this.pager = pager;

	}

	/**
	 * 抽出ワードを取得
	 * @return 抽出ワード
	 */
	public String getSearchWord() {

		return searchWord;

	}

	/**
	 * 抽出ワードを設定
	 * @param searchWord 抽出ワード
	 */
	public void setSearchWord(String searchWord) {

		this.searchWord = searchWord;

	}

}
