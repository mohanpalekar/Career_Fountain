package Locators;

import org.openqa.selenium.By;

public class SignUpPageLocators {

	public By SignUp = By.xpath("//a[text()='Sign Up']");
	public By SignUpPageText = By.xpath("//h2[text()='Add new user']");
	public By FirstName = By.id("FirstName");
	public By LastName = By .id("Surname");
	public By Email = By.id("E_post");
	public By Mobile = By.id("Mobile");
	public By Username =By.id("Username");
	public By Password = By.id("Password");
	public By ConfirmPassword =By.id("ConfirmPassword");
	public By Submit =By.id("submit");
	public By SuccesfullMessage = By.xpath("//label[text()='Registration Successful']");
	public By duplicateUser = By.xpath("//label[text()='Username already exist']");
	public By incorrectPasswordErrorMessage = By.id("ConfirmPassword-error");
	public String PasswordErrorMessage = "'Confirm password' and 'Password' do not match.";
	public String UserNameErrorMessage = "Username already exist";
	public String registrationSuccess = "Registration Successful";
}


