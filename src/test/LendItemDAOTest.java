package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.LendItemDAO;
import model.LendingItemBeans;

/**
 * LendItemDAOのテストクラス
 */
public class LendItemDAOTest {

	LendItemDAO dao;
	List<LendingItemBeans> list = new ArrayList<>();

	@Before
	public void setup() {

		dao = new LendItemDAO();

	}

	@Test
	public void アイテム貸出に成功するテスト() {

		int count = dao.insertLendItem(16, "ミント・ブラマンシュさん11111111", 1);
		assertSame(1, count);

	}

	@Test
	public void 外部キー制約により親テーブルに存在しないアイテムIDをセットしようとしてアイテム貸出に失敗するテスト() {

		int count = dao.insertLendItem(0, "田中", 1);
		assertSame(0, count);

	}

	@Test
	public void 貸出相手の名前の文字数オーバーでアイテム貸出に失敗するテスト() {

		int count = dao.insertLendItem(17, "123456789012345678901", 1);
		assertSame(0, count);

	}

	@Test
	public void 貸出相手の名前にnullを指定してアイテム貸出に失敗するテスト() {

		int count = dao.insertLendItem(17, null, 1);
		assertSame(0, count);

	}

	@Test
	public void 貸出リスト取得テスト() {

		list = dao.selectLendingItem("00001");
		assertNotSame(0, list.size());

	}

	@Test
	public void 貸出リスト取得テスト2() {

		list = dao.selectLendingItem("00002");
		assertNotSame(0, list.size());

	}

	@Test
	public void アイテム貸出リストから貸出しているアイテムを削除する() {

		int count = dao.deleteLendItem(16);
		assertSame(1, count);

	}

	@Test
	public void アイテム貸出リストからアイテム削除を失敗するテスト() {

		int count = dao.deleteLendItem(0);
		assertSame(0, count);

	}

	@Test
	public void アイテムの貸出数の取得に成功するテスト() {

		int count = dao.lendingItemCount(23);
		assertNotSame(0, count);

	}

	@Test
	public void アイテムの貸出数の取得で0を取得する() {

		int count = dao.lendingItemCount(17);
		assertSame(0, count);

	}


}
