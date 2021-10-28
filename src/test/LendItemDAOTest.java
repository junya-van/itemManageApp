package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import dao.LendItemDAO;

/**
 * LendItemDAOのテストクラス
 */
public class LendItemDAOTest {

	LendItemDAO dao;

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


}
