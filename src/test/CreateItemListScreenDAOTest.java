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

	@Test
	public void キーワード抽出して一致したアイテム数の取得に成功するテスト() {

		int count = dao.getCount("00001", "%テスト%");
		assertNotSame(0, count);

	}

	@Test
	public void キーワード抽出して一致したアイテム数の取得に失敗するテスト() {

		int count = dao.getCount("00000", "%テスト%");
		assertSame(0, count);

	}

	@Test
	public void キーワード抽出して一致したアイテム数の取得に失敗するテスト2() {

		int count = dao.getCount(null, "%テスト%");
		assertSame(0, count);

	}

	@Test
	public void キーワード抽出して一致したアイテムの取得に成功するテスト() {

		List<ItemBeans> list = dao.selectItem("00001", "%テスト%", 20, 0);
		assertNotSame(0, list.size());

	}

	@Test
	public void キーワード抽出して一致したアイテムの取得に失敗するテスト() {

		List<ItemBeans> list = dao.selectItem("00000", "%テスト%", 20, 0);
		assertSame(0, list.size());

	}

	@Test
	public void キーワード抽出して一致したアイテムの取得に失敗するテスト2() {

		List<ItemBeans> list = dao.selectItem(null, "%テスト%", 20, 0);
		assertSame(0, list.size());

	}

	@Test
	public void 特定のジャンルのアイテム数の取得に成功するテスト() {

		int count = dao.getCount("00001", 1);
		assertNotSame(0, count);

	}

	@Test
	public void 特定のジャンルのアイテム数の取得に失敗するテスト() {

		int count = dao.getCount("00001", 0);
		assertSame(0, count);

	}

	@Test
	public void 特定のジャンルのアイテム数の取得に失敗するテスト2() {

		int count = dao.getCount(null, 3);
		assertSame(0, count);

	}

	@Test
	public void 特定のジャンルのアイテム取得に成功するテスト() {

		List<ItemBeans> beans = dao.selectItem("00001", 6, 20, 0);
		assertNotSame(0, beans.size());

	}

	@Test
	public void 特定のジャンルのアイテム取得に失敗するテスト() {

		List<ItemBeans> beans = dao.selectItem("00001", 0, 20, 0);
		assertSame(0, beans.size());

	}

	@Test
	public void 特定のジャンルのアイテム取得に失敗するテスト2() {

		List<ItemBeans> beans = dao.selectItem(null, 1, 20, 0);
		assertSame(0, beans.size());

	}




}
