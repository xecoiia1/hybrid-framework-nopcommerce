package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commonJquery.GlobalConstants;

public class UserDataMapper {
	
	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public String getFirstName() {
	return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailAdd() {
		return emailAdd;
	}
	public String getPassword() {
		return password;
	}
	public String getDate() {
		return date;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}
	
	
	static class Login{
		@JsonProperty("username")
		private String username;
		@JsonProperty("password")
		private String password;
	}
	
	public String getUserName() {
		return login.username;
	}
	
	public String getLoginPassword() {
		return login.password;
	}
	
		@JsonProperty("firstName")
		private String firstName;
		
		@JsonProperty("lastName")
		private String lastName;
		
		@JsonProperty("emailAdd")
		private String emailAdd;
		
		@JsonProperty("password")
		private String password;
		
		@JsonProperty("date")
		private String date;
		
		@JsonProperty("month")
		private String month;
		
		@JsonProperty("year")
		private String year;
		
		@JsonProperty("Login")
		private Login login;
		
}
