package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConn {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
				requiredEnvironmentVariable("BOOK_STORE_DB_URL"),
				requiredEnvironmentVariable("BOOK_STORE_DB_USER"),
				requiredEnvironmentVariable("BOOK_STORE_DB_PASSWORD"));

	}

	private static String requiredEnvironmentVariable(String name) {
		String value = System.getenv(name);
		if (value == null || value.trim().isEmpty()) {
			throw new IllegalStateException("Missing required environment variable: " + name);
		}
		return value;
	}
}
