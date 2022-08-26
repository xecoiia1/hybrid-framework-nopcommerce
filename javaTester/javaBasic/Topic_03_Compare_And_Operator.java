package javaBasic;

import java.util.Scanner;

public class Topic_03_Compare_And_Operator {
	static int studentNumber;
	static boolean Name;
	
	public static void main(String[] arg) {
//		//1
//	    Scanner Ten = new Scanner(System.in);  // Create a Scanner object
//	    System.out.println("Enter name");
//	    
//	    String name = Ten.nextLine();
//	    
//	    Scanner Tuoi = new Scanner(System.in);  // Create a Scanner object
//	    System.out.println("Enter age");
//	    
//	    int age = Tuoi.nextInt();
//	    
//	    int ageAfer = age + 15;
//	    
//	    System.out.println("After 15 year, age of " + name + " will be " + ageAfer);
	    
//	    //2 
//	    Scanner numA = new Scanner(System.in);  // Create a Scanner object
//	    System.out.println("Nhap so 1");
//	    int firstNum = numA.nextInt();
//	    
//	    Scanner numB = new Scanner(System.in);  // Create a Scanner object
//	    System.out.println("Nhap so 2");
//	    
//	    int secondNum = numB.nextInt();
//	    
//	    System.out.println("Before swaping the num 1 is " + firstNum + " and the num 2 is " + secondNum);
//	    
//	    firstNum = firstNum + secondNum;
//	    secondNum = firstNum - secondNum;
//	    firstNum = firstNum - secondNum;
//	    
//	    System.out.println("After swaping the num 1 is " + firstNum + " and the num 2 is " + secondNum);
//	    
		
		//3
	    Scanner numA = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Nhap so 1");
	    int firstNum = numA.nextInt();
	    
	    Scanner numB = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Nhap so 2");
	    
	    int secondNum = numB.nextInt();
	    
	    if (firstNum > secondNum) {
	    	System.out.println("True");
	    }else if(firstNum == secondNum){
	    	System.out.println("True");
	    }else {
	    	System.out.println("Fail");
	    }
	}
}
