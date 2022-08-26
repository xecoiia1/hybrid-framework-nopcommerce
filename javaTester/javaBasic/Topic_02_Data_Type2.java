package javaBasic;

import java.util.Scanner;

public class Topic_02_Data_Type2 {
	static int studentNumber;
	static boolean Name;
	
	public static void main(String[] arg) {

		//1
		int a = 6;
		int b = 2;
		
		System.out.println(a + b + " La tong cua a va b");
		System.out.println(a - b + " La hieu cua a va b");
		System.out.println(a * b + " La tich cua a va b");
		System.out.println(a / b + " La thuong cua a va b");
		
		//2
		float Dai = 7.5f;
		float Rong = 3.8f;
		
		System.out.println("Dien tich hinh chu nhat la: " + Dai * Rong);
		
		//3
		addVar("Automation", " Testing");
		
	}
	public static void addVar(String Add, String Add2) {
		System.out.println("Hello " + Add + Add2);
	}
}
