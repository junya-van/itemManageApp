package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.LoginDAO;
import model.UserBeans;

/**
 * LoginDAOのテスト
 */
public class LoginDAOTest {

	LoginDAO dao;

	@Before
	public void setup() {

		dao = new LoginDAO();

	}

	@Test
	public void ユーザ情報取得に成功するテスト() {

		UserBeans beans = dao.selectUser("00001", "test1pass");
		assertNotNull(beans);

	}

	@Test
	public void ユーザ情報取得に失敗するテスト() {

		UserBeans beans = dao.selectUser("00000", "00000");
		assertNull(beans);

	}

}
