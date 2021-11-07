package test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Before;
import org.junit.Test;

import dao.ItemDAO;
import model.ItemBeans;

/**
 * ItemDAOのテスト
 */
public class ItemDAOTest {

	ItemDAO dao;
	ItemBeans beans;

	@Before
	public void setuo() {

		dao = new ItemDAO();

	}

	@Test
	public void アイテムの取得に成功するテスト() {

		beans = dao.selectItem(17);
		assertNotNull(beans);

	}

	@Test
	public void アイテムの取得に失敗するテスト() {

		beans = dao.selectItem(0);
		assertNull(beans);

	}

	@Test
	public void アイテム削除に成功するテスト() {

		int count = dao.deleteItem(17);
		assertSame(1, count);

	}

	@Test
	public void 存在しないアイテムIDを指定してアイテム削除に失敗するテスト() {

		int count = dao.deleteItem(0);
		assertSame(0, count);

	}

	@Test
	public void アイテム編集に成功するテスト() {

		beans = new ItemBeans();
		beans.setItemId(18);
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
