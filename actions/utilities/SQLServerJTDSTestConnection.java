package utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJTDSTestConnection {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerJTDSConnUtils.getSQLServerConnection();
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection.....");
		
		
		Connection conn = SQLServerJTDSConnUtils.getSQLServerConnection();
		
		System.out.println("Opened connection: " + conn);
		
		Statement statement = conn.createStatement();
		
		String sql = "SELECT * FROM [automationtest].[dbo].[Product_Type]";
		
		//Thực thi câu lện SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);
		
		//Duyệt trên kết quả rồi trả về
		while (rs.next()) {
			//Di chuyển con trỏ xuống bản ghi kế tiếp.
			String empFirstName = rs.getString(1);
			String empLastName = rs.getString("NAME");
			
			System.out.println("------------------");
			System.out.println("Emp FirstName:" + empFirstName);
			System.out.println("Emp LastName:" + empLastName);
			
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------Closed Connection---------");
	}
}
