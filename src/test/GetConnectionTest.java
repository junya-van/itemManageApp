package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.Test;

import dao.GetConnection;

public class GetConnectionTest extends GetConnection{

	@Test
	public void データベース接続テスト() {

		Connection con = getConnection();
		assertNotNull(con);

	}

}
