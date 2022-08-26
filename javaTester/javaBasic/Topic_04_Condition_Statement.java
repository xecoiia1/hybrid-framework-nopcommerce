package javaBasic;

import java.util.Scanner;

public class Topic_04_Condition_Statement {
	
	public static void main(String[] arg) {
//		//1
//		Scanner numA = new Scanner(System.in);
//		System.out.println("Nhap so vao");
//		
//		int numB = numA.nextInt();
//		
//		if(numB % 2 ==0) {
//			System.out.println("So Chan");
//		}else {
//			System.out.println("So Le");
//			}
		
		//2
//		Scanner numA = new Scanner(System.in);
//		System.out.println("Nhap so vao");
//		
//		int numB = numA.nextInt();
//		
//		Scanner numC = new Scanner(System.in);
//		System.out.println("Nhap so vao");
//		
//		int numD = numC.nextInt();
//		
//		if(numB >= numD) {
//			System.out.println("So A lon hon hoac bang So B");
//		}else {
//			System.out.println("So A nho hon So B");
//		}
//		
//		//3
//		Scanner textA = new Scanner(System.in);
//		System.out.println("Nhap ten vao");
//		
//		String a = textA.nextLine();
//		
//		Scanner textB = new Scanner(System.in);
//		System.out.println("Nhap ten vao");
//		
//		String b = textB.nextLine();
//		
//		if(a.equals(b)) {
//			System.out.println("2 nguoi cung ten");
//		}else {
//			System.out.println("2 nguoi khac ten");
//		}
		//4
//		Scanner textA = new Scanner(System.in);
//		System.out.println("Nhap so 1: ");
//		
//		int a = textA.nextInt();
//		
//		Scanner textB = new Scanner(System.in);
//		System.out.println("Nhap so 2: ");
//		
//		int b = textB.nextInt();
//		
//		Scanner textC = new Scanner(System.in);
//		System.out.println("Nhap so 3: ");
//		
//		int c = textC.nextInt();
		
//		if (a > b) {
//			if (a > c) {
//				System.out.println("So lon nhat la: " + a);
//			}else if (a < c) {
//				System.out.println("So lon nhat la: " + c);
//			}
//		}else if (a < b) {
//			if (b > c) {
//				System.out.println("So lon nhat la: " + b);
//			}else if (b < c) {
//				System.out.println("So lon nhat la: " + c);
//			}
//		}else {
//			System.out.println("3 so bang nhau");
//		}
//	
//	if (a > b && a > c) {
//		System.out.println("So lon nhat la: " + a);
//	}else if(b > c) {
//		System.out.println("So lon nhat la: " + b);
//	}else {
//		System.out.println("So lon nhat la: " + c);
//	}
		//5 
		Scanner textA = new Scanner(System.in);
		System.out.println("Nhap so 1: ");
		
		int a = textA.nextInt();
		if (a >= 10 && a <= 100) {
			System.out.println("A nam trong khoang 10 - 100 ");
		}else {
			System.out.println("A khong nam trong khoang 10 - 100 ");
		}
	
	}
}