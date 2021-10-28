package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.LendingItemBeans;
import model.LendingListLogic;

public class LendingListLogicTest {

	LendingListLogic logic;

	@Before
	public void setup() {

		logic = new LendingListLogic();

	}

	@Test
	public void アイテム貸出リストを取得するテスト() {

		List<LendingItemBeans> list = logic.execute("00001");
		assertNotSame(0, list.size());

	}

}
