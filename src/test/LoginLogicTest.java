package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.LoginLogic;
import model.UserBeans;

public class LoginLogicTest {

	LoginLogic logic;

	@Before
	public void setup() {

		logic = new LoginLogic();

	}

	@Test
	public void ユーザ情報取得に成功するテスト() {

		UserBeans beans = logic.execute("00001", "test1pass");
		assertNotNull(beans);

	}

	@Test
	public void ユーザ情報取得に失敗するテスト() {

		UserBeans beans = logic.execute("00000", "00000");
		assertNull(beans);

	}

}
