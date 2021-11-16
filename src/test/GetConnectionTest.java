package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import dao.GetConnection;

public class GetConnectionTest extends GetConnection{

	Connection con;

	@Test
	public void データベース接続テスト() {

		con = getConnection();
		assertThat(con, notNullValue());

	}

	@Test
	public void JDBCドライバのロードに失敗するテスト() {

		try {

			Class.forName("");
			fail();	// このメソッドが実行されなければテスト成功

		} catch(ClassNotFoundException e) {}

	}

	@Test
	public void データベース接続に失敗するテスト() {

		try {

			con = DriverManager.getConnection("", "", "");
			fail();	// このメソッドが実行されなければテスト成功

		}catch(SQLException e) {}

	}

}
