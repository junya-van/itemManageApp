package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import dao.UserInsertDAO;
import model.UserBeans;

public class UserInsertDAOTest {

	UserInsertDAO dao;
	UserBeans beans;

	@Before
	public void setup() {

		dao = new UserInsertDAO();

	}

	@Test
	public void ユーザ情報登録に成功するテスト() {

		beans = new UserBeans("00003", "test03pass", "テスト3太郎000000000");
		int count = dao.insertUser(beans);
		assertSame(1, count);

	}

	@Test
	public void ユーザ情報登録に成功するテスト2() {

		beans = new UserBeans("00004", "test_4pass", "テ");
		int count = dao.insertUser(beans);
		assertSame(1, count);

	}



	@Test
	public void ユーザIDがnullの為ユーザ情報登録に失敗するテスト() {

		beans = new UserBeans(null, "test5", "テスト5太郎");
		int count = dao.insertUser(beans);
		assertSame(0, count);

	}

	@Test
	public void パスワードがnullの為ユーザ情報登録に失敗するテスト() {

		beans = new UserBeans("00005", null, "テスト5太郎");
		int count = dao.insertUser(beans);
		assertSame(0, count);

	}

	@Test
	public void ユーザ名がnullの為ユーザ情報登録に失敗するテスト() {

		beans = new UserBeans("00005", "test5pass", null);
		int count = dao.insertUser(beans);
		assertSame(0, count);

	}

}
