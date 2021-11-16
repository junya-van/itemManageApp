package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemDeleteLogic;

/**
 * ItemDeleteLogicのテスト
 */
public class ItemDeleteLogicTest {

	ItemDeleteLogic logic;

	@Before
	public void setup() {

		logic = new ItemDeleteLogic();

	}

	@Test
	public void アイテム削除に成功するテスト() {

		int count = logic.execute(27);
		assertSame(1, count);

	}

	@Test
	public void 存在しないアイテムIDを指定してアイテム削除に失敗するテスト() {

		int count = logic.execute(0);
		assertSame(0, count);

	}

}
