package model;

/**
 * ユーザ情報を格納するBeansクラス
 */
public class UserBeans implements java.io.Serializable {

	private String userId;	// ユーザID
	private String pass;	// パスワード
	private String name;	// ユーザ名

	public UserBeans() {}

	public UserBeans(String userId, String pass, String name) {

		this.userId = userId;
		this.pass = pass;
		this.name = name;

	}

	/**
	 * ユーザIDを取得
	 * @return ユーザID
	 */
	public String getUserId() {

		return userId;

	}

	/**
	 * ユーザIDを設定
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {

		this.userId = userId;

	}

	/**
	 * パスワードを取得
	 * @return パスワード
	 */
	public String getPass() {

		return pass;

	}

	/**
	 * パスワードを設定
	 * @param pass パスワード
	 */
	public void setPass(String pass) {

		this.pass = pass;

	}

	/**
	 * ユーザ名を取得
	 * @return ユーザ名
	 */
	public String getName() {

		return name;

	}

	/**
	 * ユーザ名を設定
	 * @param name ユーザ名
	 */
	public void setName(String name) {

		this.name = name;

	}


}
