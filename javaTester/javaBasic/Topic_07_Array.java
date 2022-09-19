package javaBasic;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_07_Array {
	int ram [] = {1 , 10, 3, 4, 5};
	@Test
	public void TC_01_Tim_So_Lon_Nhat_Trong_Mang(){
		
		// Bài 1: Tìm số lớn nhất trong mảng
		// Tìm số lớn nhất trong mảng: Duyệt qua tất các các số trong mảng bằng vòng lặp for, sau đó tạo 1 biến x =0
		// Sau đó tiến hành gán x với các số trong mảng, nếu số nào lớn hơn thì gán lại vào X
			int x = 0;
			
			for (int i =0; i < ram.length; i++) {
				if (x < ram[i]) {
					x = ram[i];
					
				}
			}	
			System.out.println(x);
}		
	@Test
	public void TC_02_Sum_First_Number_And_Last_Number(){
		// Bài 2: Tính tổng của số đầu tiên + số cuối cùng trong mảng
		// Số đầu tiên trong mảng sẽ có index là ram[0] và số cuối cùng trongg mảng sẽ là ram[ram.length-1]
		// Chỉ cần gọi 2 số ra và cộng vào là xong
			System.out.println("Tong 2 so la: " + (ram[0] +ram[ram.length - 1]));
			
		
	}
	@Test	
	public void TC_03_Tinh_Tong_Va_Trung_Binh_Cong(){
		// Bài 3: Tính Trung bình Cộng và tổng các số trong mảng
		// Khai báo 1 biến sum
		// Duyệt qua mảng bằng vòng lặp for
		// Gán sum vào các lần duyệt đó sum = sum + ram[0], sum + ram[1].....
		// Kết thúc sẽ ra tổng của các số trong mảng
		int sum = 0;
		for(int i =0; i< ram.length; i++) {
			sum += ram[i];
		}
		System.out.println(sum);
		System.out.println("Average: " + (sum/ram.length));
	}
		
}


