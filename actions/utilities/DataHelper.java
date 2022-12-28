package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	
	private Locale local = new Locale("vi");
	
	private Faker faker = new Faker();
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAdd() {
		return faker.internet().emailAddress();
	}
	
	public String getCityName() {
		return faker.address().city();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getAddres() {
		return faker.address().streetAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
}
