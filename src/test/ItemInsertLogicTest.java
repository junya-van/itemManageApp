package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemBeans;
import model.ItemInsertLogic;

/**
 * ItemInsertLogicのテスト
 */
public class ItemInsertLogicTest {

	ItemBeans beans;
	ItemInsertLogic logic;

	@Before
	public void setup() {

		logic = new ItemInsertLogic();

	}

	@Test
	public void アイテム情報登録に成功するテスト() {

		beans = new ItemBeans();
		beans.setItemName("テストブック5");
		beans.setProduct("テスト社");
		beans.setJan("1111111111111");
		beans.setGenreId(5);
		beans.setQuantity(1);
		int count = logic.execute("00002", beans);
		assertNotSame(0, count);

	}

	@Test
	public void アイテム情報登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName(null);
		beans.setProduct("テスト社");
		beans.setJan("1111111111111");
		beans.setGenreId(5);
		beans.setQuantity(1);
		int count = logic.execute("00002", beans);
		assertSame(0, count);

	}

}
