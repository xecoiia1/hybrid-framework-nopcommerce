package javaBasic;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_08_String {
	String Name = "Thanh Nguyen Dep Trai";
	String NameLol = "Thanh Nguyen Dep TRAI";
	String SubName = "Vo dich thien ha";
	
	@Test
	public void TC_01_Example() {
	//Độ dài của chuỗi
	System.out.println(Name.length());
	
	//Lấy ra kí tự
	System.out.println(Name.charAt(3));
	
	//Nối chuỗi
	System.out.println(Name.concat(SubName));
	
	System.out.println(Name + SubName);
	
	//So sánh 2 chuỗi bằng nhau tuyệt đối
	System.out.println(Name.equals(SubName));
	
	//So sánh 2 chuỗi bằng nhau tương đối
	System.out.println(Name.equalsIgnoreCase(NameLol));
	}	
}


