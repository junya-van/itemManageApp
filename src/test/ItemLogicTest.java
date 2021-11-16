package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemBeans;
import model.ItemLogic;

/**
 * ItemLogicのテスト
 * @author 潤也
 *
 */
public class ItemLogicTest {

	ItemLogic logic;
	ItemBeans beans;

	@Before
	public void setup() {

		logic = new ItemLogic();

	}

	@Test
	public void アイテム情報取得に成功するテスト() {

		beans = logic.execute(25);
		assertNotNull(beans);

	}

	@Test
	public void アイテム情報取得に失敗するテスト() {

		beans = logic.execute(0);
		assertNull(beans);

	}

}
