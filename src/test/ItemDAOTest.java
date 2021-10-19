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

}
