package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import model.UserBeans;
import model.UserInsertLogic;

/**
 * UserInsertLogicのテストクラス
 */
public class UserInsertLogicTest {

	UserInsertLogic logic;
	UserBeans beans;

	@Before
	public void setup() {

		logic = new UserInsertLogic();

	}

	@Test
	public void ユーザ情報登録に成功するテスト() {

		beans = new UserBeans("00007", "test7pass", "テスト7太郎");
		int count = logic.execute(beans);
		assertSame(1, count);

	}

	@Test
	public void ユーザIDが重複しているのでユーザ情報登録に失敗するテスト() {

		beans = new UserBeans("00001", "test4pass", "テスト4太郎");
		int count = logic.execute(beans);
		assertSame(0, count);

	}

}
