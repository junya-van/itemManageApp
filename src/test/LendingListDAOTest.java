package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.LendingListDAO;
import model.LendingItemBeans;

public class LendingListDAOTest {

	LendingListDAO dao;
	List<LendingItemBeans> list = new ArrayList<>();

	@Before
	public void setup() {

		dao = new LendingListDAO();

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



}
