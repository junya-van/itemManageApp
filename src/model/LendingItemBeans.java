package model;

import java.time.LocalDate;

/**
 * 貸出アイテムの情報を格納するBeansクラス
 */
public class LendingItemBeans implements java.io.Serializable {

	private int lendId;	// 貸出ID
	private int itemId;	// アイテムID
	private String itemName;	// アイテム名
	private int lend_quantity;	// 貸出数
	private String to_who;		// 貸出相手の名前
	private LocalDate lent_at;	// 貸出日

	/**
	 * 貸出IDを取得
	 * @return 貸出ID
	 */
	public int getLendId() {

		return lendId;

	}

	/**
	 * 貸出IDを設定
	 * @param lendId 貸出ID
	 */
	public void setLendId(int lendId) {

		this.lendId = lendId;

	}

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
	 * 貸出数を取得
	 * @return 貸出数
	 */
	public int getLend_quantity() {

		return lend_quantity;

	}

	/**
	 * 貸出数を設定
	 * @param lend_quantity	貸出数
	 */
	public void setLend_quantity(int lend_quantity) {

		this.lend_quantity = lend_quantity;

	}

	/**
	 * 貸出対象を取得
	 * @return 貸出対象
	 */
	public String getTo_who() {

		return to_who;

	}

	/**
	 * 貸出対象を設定
	 * @param to_who 貸出対象
	 */
	public void setTo_who(String to_who) {

		this.to_who = to_who;

	}

	/**
	 * 貸出日を取得
	 * @return 貸出日
	 */
	public LocalDate getLent_at() {

		return lent_at;

	}

	/**
	 * 貸出日を設定
	 * @param lent_at 貸出日
	 */
	public void setLent_at(LocalDate lent_at) {

		this.lent_at = lent_at;

	}

}
