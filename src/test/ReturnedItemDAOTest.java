package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import dao.ReturnedItemDAO;

/**
 * ReturnedItemDAOのテストクラス
 */
public class ReturnedItemDAOTest {

	ReturnedItemDAO dao;

	@Before
	public void setup() {

		dao = new ReturnedItemDAO();

	}

	@Test
	public void アイテム貸出リストから貸出しているアイテムを削除する() {

		int count = dao.deleteLendItem(3);
		assertSame(1, count);

	}

	@Test
	public void アイテム貸出リストからアイテム削除を失敗するテスト() {

		int count = dao.deleteLendItem(0);
		assertSame(0, count);

	}

}
