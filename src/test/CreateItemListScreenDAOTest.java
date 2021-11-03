package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.CreateItemListScreenDAO;
import model.ItemBeans;

/**
 * CreateItemListScreenDAOのテストクラス
 */
public class CreateItemListScreenDAOTest {

	CreateItemListScreenDAO dao;

	@Before
	public void setup() {

		dao = new CreateItemListScreenDAO();

	}

	@Test
	public void getCountメソッドのテスト成功() {

		int count = dao.getCount("00001");
		assertNotSame(0, count);

	}

	@Test
	public void getCountメソッドのテスト失敗() {

		int count = dao.getCount("00000");
		assertSame(0, count);

	}

	@Test
	public void getCountメソッドのテスト失敗2() {

		int count = dao.getCount(null);
		assertSame(0, count);

	}

	@Test
	public void selectItemメソッドのテスト成功() {

		List<ItemBeans> list = dao.selectItem("00001", 20, 0);
		assertNotSame(0, list.size());

	}

	@Test
	public void selectItemメソッドのテスト失敗() {

		List<ItemBeans> list = dao.selectItem(null, 20, 0);
		assertSame(0, list.size());

	}



}
