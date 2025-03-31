package menubook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	private static Connection connection;
	private static Properties dbProperties;
	private static Properties sqlProperties;

	private DBUtils() {}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			dbProperties = new Properties();
			dbProperties.load(DBUtils.class.getResourceAsStream("db.properties"));

			sqlProperties = new Properties();
			sqlProperties.load(DBUtils.class.getResourceAsStream("sql.properties"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} // try ~ catch
	} // static initializer

	public static synchronized Connection getConnection() throws SQLException {

		if (connection == null) {
			connection = DriverManager.getConnection(
					dbProperties.getProperty("url")
					, dbProperties.getProperty("user")
					, dbProperties.getProperty("password"));
		} // if

		return connection;
	} // getSingleConnection

	public static void closeSingleConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	} // closeSingleConnection

	public static Properties getSqlProperties() {
		return sqlProperties;
	} // getSqlProperties

} // class
