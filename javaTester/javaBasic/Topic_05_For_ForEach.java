package javaBasic;

import java.util.Scanner;

public class Topic_05_For_ForEach {
	
	public static void main(String[] arg) {
//		//1
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Input a: ");
//		int a = scanner.nextInt();
//		
//		for ( int i = 0; i <= a; i++ ) {
//			System.out.print(" " + i);
//		}
		//2
//		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		
//		if (a < b) {
//		for (;a<=b;a++) {
//			System.out.print(a + " ");
//		}
//		}else if(a > b) {
//			for (;a>=b;a--) {
//				System.out.print(a + " ");
//			}
//		}
		
		//3
//		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();
//		
//		for (; a <=10; a++) {
//			if (a%2==0) {
//				System.out.println(a);
//			}
//		}
		
		//4
		Scanner sc = new Scanner(System.in);
	
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(i * 5 + j + " ");
			}
			System.out.println();
		}
			
	}
}