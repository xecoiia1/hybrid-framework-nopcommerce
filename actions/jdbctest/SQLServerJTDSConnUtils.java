package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationtest";
		String userName = "sa";
		String password = "automationfc";
		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}
	
	private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			//Khai báo class Driver cho MySQL
			//Việc này cần thiết với Java 5
			//Java 6 tự động tìm kiếm Driver thích hợp - không bắt buộc cần dòng này
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
			//Cấu trúc URL Connection dành cho SQLServer
			//Ví dụ: jdbc:mysql://localhost:3306/automationfc
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance=" + sqlInstanceName;
			
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
    }
}