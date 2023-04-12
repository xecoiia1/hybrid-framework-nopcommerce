package pageObjects.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUIs.wordpress.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePageJquery {
	WebDriver driver;

	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getUserNumberAtUI() {
		waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		String totalNumber = getTextOfElement(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		//3 items
		String totalArray[] = totalNumber.split(" ");
		totalNumber = totalArray[0];
		return Integer.parseInt(totalNumber.split(" ")[0]);
	}
	
	public int getUserNumberAtDB() {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		List<Integer> totalUser = new ArrayList<Integer>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM wp_users";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				//Di chuyển con trỏ xuống bản ghi kế tiếp.
				totalUser.add(rs.getInt(1));				
				System.out.println("------------------");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalUser.size();
	}

}
