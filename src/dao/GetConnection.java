package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベース接続をするクラス
 */
public class GetConnection {

	// データベース接続に関する情報
	private static final String DB_USER = "root";
	private static final String DB_PASS = "MYSQLJUNYA";
	private static final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/itemManageApp";

	static Connection con = null;

	/**
	 * データベース接続する
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(JDBC_NAME);
		con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		return con;

	}
}
