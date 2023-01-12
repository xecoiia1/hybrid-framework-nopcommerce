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
	@Test
	public class Topic04_String {
		String courseName = "Auto Matio Tester";
		@Test
		// Bài 1
		// Tìm số lượng của các chữ viết hoa trong chuỗi
		// Split các từ trong chuỗi về array
		// Duyệt qua tất cả các chữ trong Array với for và đk charater >= 'A' &&  <= 'Z'
		// Khai báo 1 biến Count để đếm, mỗi khi duyệt được 1 chữ cái UpperCase thì count++ -> sẽ ra số lượng uppercase sau khi duyệt xong
		// Có thể áp dụng để đếm số lương uppercase và number
		public void TC_01 () {
			String Name = "Anh Thanh Sieu Dep Trai Online";
			int count = 0 ;
			
			char splitName[] = Name.toCharArray();
			
			for(char charater: splitName) {
				if(charater <= 'Z' && charater >= 'A') {
						count++;
				}
			}
			System.out.println("Số lượng UpperCase là: " + count);
		}
		@Test
		public void TC_02() {
			
		}

//		public static void main(String[] args) {
	//
//			String Name = "Anh Thanh Dep Trai";
//			
//			// Xác định ví trí của từ trong chuỗi
//			System.out.println("Vị trí của từ trong chuỗi: " + Name.indexOf("D"));
//			
//			// Tách 1 kí tự/ chuỗi kí tự
//			System.out.println(Name.substring(10));
//			System.out.println(Name.substring(10, 13));
//			
//			//Split tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
//			String result = "Viewing 48 of 132 result";
//			String results[] = result.split(" ");
//			for(String string : results) {
//				System.out.println(string);
//			}
//			System.out.println(results[1]);
//			
//			//Replace một ký tự trong chuỗi thành một ký tự khác
//			String replace = "1000$";
//			replace = replace.replace("$", "0");
//			System.out.println(replace);
//			
//			//Ép kiểu sang một kiểu dữ liệu khác vd: String -> Float
//			float replaceF = Float.parseFloat(replace);
//			System.out.println(replaceF);
//			
//			// Đại diện cho 1 chuỗi: %s
//			// Ví Dụ:
//			String dynamicButton = "%s";
//			
//			System.out.println(dynamicButton.format(dynamicButton, "Thanh"));
//			
//			
//			
	//
//		}
	}	
}


