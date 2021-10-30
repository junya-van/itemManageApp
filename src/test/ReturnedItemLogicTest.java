package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import model.ReturnedItemLogic;

public class ReturnedItemLogicTest {

	ReturnedItemLogic logic;

	@Before
	public void setup() {

		logic = new ReturnedItemLogic();

	}

	@Test
	public void アイテム返却処理に成功するテスト() {

		int count = logic.execute(7);
		assertSame(1, count);

	}

	@Test
	public void アイテム返却処理に失敗するテスト() {

		int count = logic.execute(0);
		assertSame(0, count);

	}

}
