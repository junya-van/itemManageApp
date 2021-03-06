package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * アイテム情報を格納するBeansクラス(itemテーブルとLendingListテーブルの一部を結合)
 */
public class ItemBeans implements java.io.Serializable {

	private int itemId;		// アイテムID
	private String itemName;	// アイテム名
	private String product;		// メーカー(制作会社、出版社等)
	private String jan;			// JANコード
	private String genre;		// ジャンル名
	private int genreId;		// ジャンルID
	private int quantity;		// 所持数
	private int lend_quantity;	// 貸出数
	private int score;			// 評価
	private String imgName;		// 画像名
	private LocalDateTime created_at;	// 登録日
	private LocalDateTime updated_at;	// 更新日

	/**
	 * アイテムIDを取得
	 * @return アイテムID
	 */
	public int getItemId() {

		return itemId;

	}

	/**
	 * アイテムIDを設定
	 * @param itemId アイテムID
	 */
	public void setItemId(int itemId) {

		this.itemId = itemId;

	}

	/**
	 * アイテム名を取得
	 * @return アイテム名
	 */
	public String getItemName() {

		return itemName;

	}

	/**
	 * アイテム名を設定
	 * @param itemName	アイテム名
	 */
	public void setItemName(String itemName) {

		this.itemName = itemName;

	}

	/**
	 * メーカー名を取得
	 * @return メーカー名
	 */
	public String getProduct() {

		return product;

	}

	/**
	 * メーカー名を設定
	 * @param product メーカー名
	 */
	public void setProduct(String product) {

		this.product = product;

	}

	/**
	 * JANコードを取得
	 * @return JANコード
	 */
	public String getJan() {

		return jan;

	}

	/**
	 * JANコードを設定
	 * @param jan JANコード
	 */
	public void setJan(String jan) {

		this.jan = jan;

	}

	/**
	 * ジャンルを取得
	 * @return ジャンル
	 */
	public String getGenre() {

		return genre;

	}

	/**
	 * ジャンルを設定
	 * @param genre ジャンル
	 */
	public void setGenre(String genre) {

		this.genre = genre;

	}

	public int getGenreId() {

		return genreId;

	}

	public void setGenreId(int genreId) {

		this.genreId = genreId;

	}

	/**
	 * 所持数を取得
	 * @return 所持数
	 */
	public int getQuantity() {

		return quantity;

	}

	/**
	 * 所持数を設定
	 * @param quantity 所持数
	 */
	public void setQuantity(int quantity) {

		this.quantity = quantity;

	}

	/**
	 * 貸出数を取得
	 * @return	貸出数
	 */
	public int getLend_quantity() {

		return lend_quantity;

	}

	/**
	 * 貸出数を設定
	 * @param lend_quantity 貸出数
	 */
	public void setLend_quantity(int lend_quantity) {

		this.lend_quantity = lend_quantity;

	}

	/**
	 * 評価を取得
	 * @return 評価
	 */
	public int getScore() {

		return score;

	}

	/**
	 * 評価を設定
	 * @param score 評価
	 */
	public void setScore(int score) {

		this.score = score;

	}

	/**
	 * 画像名を取得
	 * @return 画像名
	 */
	public String getImgName() {

		return imgName;

	}

	/**
	 * 画像名を設定
	 * @param imgName 画像名
	 */
	public void setImgName(String imgName) {

		this.imgName = imgName;

	}

	/**
	 * 登録日を取得
	 * @return 登録日
	 */
	public String getCreated_at() {

		return created_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	}

	/**
	 * 登録日を設定
	 * @param created_ad 登録日
	 */
	public void setCreated_at(LocalDateTime created_ad) {

		this.created_at = created_ad;

	}

	/**
	 * 更新日を取得
	 * @return 更新日
	 */
	public String getUpdated_at() {

		return updated_at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	}

	/**
	 * 更新日を設定
	 * @param updated_at 更新日
	 */
	public void setUpdated_at(LocalDateTime updated_at) {

		this.updated_at = updated_at;

	}

}
