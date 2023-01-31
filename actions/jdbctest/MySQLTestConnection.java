package jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection.....");
		
		
		Connection conn = MySQLTestConnection.getMyConnection();
		
		System.out.println("Opened connection: " + conn);
		
		Statement statement = conn.createStatement();
		
		String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";
		
		//Thực thi câu lện SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);
		
		//Duyệt trên kết quả rồi trả về
		while (rs.next()) {
			//Di chuyển con trỏ xuống bản ghi kế tiếp.
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			
			System.out.println("------------------");
			System.out.println("Emp Id:" + empId);
			System.out.println("Emp FirstName:" + empFirstName);
			System.out.println("Emp LastName:" + empLastName);
			
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------Closed Connection---------");
	}
}
