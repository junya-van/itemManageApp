package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.ItemInsertDAO;
import model.ItemBeans;

/**
 * ItemInsertDAOのテスト
 */
public class ItemInsertDAOTest {

	ItemInsertDAO dao;
	ItemBeans beans;

	@Before
	public void setup() {

		dao = new ItemInsertDAO();

	}

	@Test
	public void アイテム登録に成功するテスト() {

		beans = new ItemBeans();
		beans.setItemName("12345678901234567890123456789012345678901234567890");
		beans.setProduct("12345678901234567890");
		beans.setJan("1111111111111");
		beans.setGenreId(2);
		beans.setQuantity(1);
		int count = dao.insertItem("00001", beans);
		assertNotSame(0, count);

	}

	@Test
	public void アイテム登録に成功するテスト2() {

		beans = new ItemBeans();
		beans.setItemName("あ");
		beans.setProduct("い");
		beans.setGenreId(3);
		beans.setQuantity(2);
		int count = dao.insertItem("00002", beans);
		assertNotSame(0, count);

	}

	@Test
	public void アイテム名が長すぎてアイテム登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName("123456789012345678901234567890123456789012345678901");
		beans.setProduct("株式会社A");
		beans.setGenreId(4);
		beans.setQuantity(1);
		int count = dao.insertItem("00001", beans);
		assertSame(0, count);

	}

	@Test
	public void メーカー名が長すぎてアイテム登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName("テストブック");
		beans.setProduct("123456789012345678901");
		beans.setGenreId(1);
		beans.setQuantity(1);
		int count = dao.insertItem("00001", beans);
		assertSame(0, count);

	}

	@Test
	public void JANコードが長すぎてアイテム登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName("テストブック2");
		beans.setProduct("出版社B");
		beans.setJan("12345678901234");
		beans.setGenreId(2);
		beans.setQuantity(1);
		int count = dao.insertItem("00001", beans);
		assertSame(0, count);

	}

	@Test
	public void NULLを入れようとしてアイテム登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName(null);
		beans.setGenreId(1);
		beans.setQuantity(1);
		int count = dao.insertItem("00001", beans);
		assertSame(0, count);

	}

	@Test
	public void ジャンルIDに親テーブルの主キーのカラムに入ってる値以外のものを入れようとしてアイテム登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName("テストブック2");
		beans.setGenreId(10);
		beans.setQuantity(1);
		int count = dao.insertItem("00001", beans);
		assertSame(0, count);

	}

	@Test
	public void 所持数に0を入れようとしてアイテム登録に失敗するテスト() {

		beans = new ItemBeans();
		beans.setItemName("テストブック3");
		beans.setGenreId(1);
		beans.setQuantity(0);
		int count = dao.insertItem("00001", beans);
		assertSame(0, count);

	}



}
