package javaBasic;
import java.util.Scanner;

public class Topic_06_While_Do_While {
	static int studentNumber;
	static boolean Name;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] arg) {
		
//		int a = 1;
//		int i = 1;
//		
//		while(a <5) {
//			System.out.println(a);
//			a++;
//		}
//		
//		do {
//			System.out.println(i);
//			i++;
//		} while (i < 5);
		
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		
//		while (a < b) {
//			if(a % 2 == 0 && a % 10 == 0) {
//				System.out.println(a);
//			}
//			a++;
//		}

		int a = scanner.nextInt();
		int q = 0 ;
		
		while (a > 0) {
			if(a % 2 != 0 ) {
				System.out.println(a);
				q += a;
			}
			a--;
		}
	}
}
