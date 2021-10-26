package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.ItemDeleteDAO;

public class ItemDeleteDAOTest {

	ItemDeleteDAO dao;

	@Before
	public void setup() {

		dao = new ItemDeleteDAO();

	}

	@Test
	public void アイテム削除に成功するテスト() {

		int count = dao.deleteItem(12);
		assertSame(1, count);

	}

	@Test
	public void 存在しないアイテムIDを指定してアイテム削除に失敗するテスト() {

		int count = dao.deleteItem(0);
		assertSame(0, count);

	}

}
