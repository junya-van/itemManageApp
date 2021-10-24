package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.ItemEditDAO;
import model.ItemBeans;

/**
 * ItemEditDAOのテスト
 */
public class ItemEditDAOTest {

	ItemEditDAO dao;
	ItemBeans beans;

	@Before
	public void setup() {

		dao = new ItemEditDAO();

	}

	@Test
	public void アイテム編集に成功するテスト() {

		beans = new ItemBeans();
		beans.setItemId(12);
		beans.setItemName("テストブック4改");
		beans.setProduct("株式会社X");
		beans.setJan("1234567890123");
		beans.setGenreId(4);
		beans.setQuantity(3);
		beans.setScore(1);
		beans.setImgName("51p6dqvB3lL._SY291_BO1,204,203,200_QL40_ML2_.jpg");

		int count = dao.updateItem(beans);
		assertSame(1, count);

	}

	@Test
	public void 存在しないアイテムIDを指定してアイテム編集に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemId(0);
		beans.setItemName("テストブック4改");
		beans.setProduct("株式会社X");
		beans.setJan("1234567890123");
		beans.setGenreId(4);
		beans.setQuantity(3);
		beans.setScore(1);
		beans.setImgName("51p6dqvB3lL._SY291_BO1,204,203,200_QL40_ML2_.jpg");

		int count = dao.updateItem(beans);
		assertSame(0, count);

	}

}
