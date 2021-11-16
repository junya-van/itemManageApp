package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemBeans;
import model.ItemEditLogic;

public class ItemEditLogicTest {

	ItemEditLogic logic;
	ItemBeans beans;

	@Before
	public void setup() {

		logic = new ItemEditLogic();

	}

	@Test
	public void アイテム編集に成功するテスト() {

		beans = new ItemBeans();
		beans.setItemId(25);
		beans.setItemName("テストブック4改2");
		beans.setProduct("株式会社X");
		beans.setJan("1234567890123");
		beans.setGenreId(4);
		beans.setQuantity(3);
		beans.setScore(1);
		beans.setImgName("51p6dqvB3lL._SY291_BO1,204,203,200_QL40_ML2_.jpg");

		int count = logic.execute(beans);
		assertSame(1, count);

	}

	@Test
	public void 存在しないアイテムIDを指定してアイテム編集に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemId(0);
		beans.setItemName("テストブック4改2");
		beans.setProduct("株式会社X");
		beans.setJan("1234567890123");
		beans.setGenreId(4);
		beans.setQuantity(3);
		beans.setScore(1);
		beans.setImgName("51p6dqvB3lL._SY291_BO1,204,203,200_QL40_ML2_.jpg");

		int count = logic.execute(beans);
		assertSame(0, count);

	}

}
