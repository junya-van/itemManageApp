package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.CreateItemListScreenDAO;
import model.ItemBeans;

public class CreateItemListScreenDAOTest {

	CreateItemListScreenDAO dao;

	@Before
	public void setup() {

		dao = new CreateItemListScreenDAO();

	}

	@Test
	public void getCountメソッドのテスト() {

		int result = dao.getCount("00001", "%%");
		assertNotSame(0, result);

	}

	@Test
	public void getCountメソッドのテスト2() {

		int result = dao.getCount("00001", "%テスト%");
		assertNotSame(0, result);

	}

	@Test
	public void getCountメソッドのテスト3() {

		int result = dao.getCount("00000", "%%");
		assertSame(0, result);

	}

	@Test
	public void selectItemメソッドのテスト() {

		List<ItemBeans> list = dao.selectItem("00001", 20, 0, "%%");
		assertNotSame(0, list.size());

	}

	@Test
	public void selectItemメソッドのテスト2() {

		List<ItemBeans> list = dao.selectItem("00001", 20, 0, "%テスト%");
		assertNotSame(0, list.size());

	}

}
