package javaBasic;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Topic_11_Faker {
	public static void main(String[] args) throws InterruptedException {
			Faker faker = new Faker();
			
			System.out.println(faker.address().firstName());
			System.out.println(faker.address().lastName());
			
			
			Faker fakerVI = new Faker(new Locale("vi"));
			System.out.println(fakerVI.address().firstName());
			System.out.println(fakerVI.address().lastName());
	
	}


}
