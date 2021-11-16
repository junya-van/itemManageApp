package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.LendItemLogic;

/**
 * LendItemLogicのテストクラス
 * @author 潤也
 *
 */
public class LendItemLogicTest {

	LendItemLogic logic;

	@Before
	public void setup() {

		logic = new LendItemLogic();

	}

	@Test
	public void アイテム貸出に成功するテスト() {

		int count = logic.execute(95, "ヤマダ", 1);
		assertSame(1, count);

	}

	@Test
	public void アイテム貸出に失敗するテスト() {

		int count = logic.execute(0, "田中", 1);
		assertSame(0, count);

	}

}
