package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import dao.ItemDAO;
import model.ItemBeans;

/**
 * ItemDAOのテスト
 */
public class ItemDAOTest {

	ItemDAO dao;
	ItemBeans beans;

	@Before
	public void setuo() {

		dao = new ItemDAO();

	}

	@Test
	public void アイテムの取得に成功するテスト() {

		beans = dao.selectItem(12);
		assertNotNull(beans);

	}

	@Test
	public void アイテムの取得に失敗するテスト() {

		beans = dao.selectItem(0);
		assertNull(beans);

	}

	@Test
	public void アイテムの貸出数の取得に成功するテスト() {

		int count = dao.lendingItemCount(13);
		assertNotSame(0, count);

	}

	@Test
	public void アイテムの貸出数の取得で0を取得する() {

		int count = dao.lendingItemCount(12);
		assertSame(0, count);

	}

}
