package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.SearchItemNameDAO;

/**
 * SearchItemNameDAOテストクラス
 */
public class SearchItemNameDAOTest {

	SearchItemNameDAO dao;

	@Before
	public void setup() {

		dao = new SearchItemNameDAO();

	}

	@Test
	public void アイテム名の部分一致検索テスト() {

		List<String> list = dao.selectItemName("00001", "テスト");
		assertNotSame(0, list.size());

	}

	@Test
	public void 部分一致検索につかう文字列にnullを指定してアイテム名の部分一致検索テスト字に要素0のリストが返ってくる() {

		List<String> list = dao.selectItemName("00001", null);
		assertSame(0, list.size());

	}

	@Test
	public void 存在しないユーザIDを指定してアイテム名の部分一致検索テスト時に要素0のリストが返ってくる() {

		List<String> list = dao.selectItemName("00000", "test");
		assertSame(0, list.size());

	}

}
