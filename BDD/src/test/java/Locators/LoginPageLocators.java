package Locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
	public By LoginButtonHomePage = By.xpath("//a[text()='Login']");
	public By username = By.id("Username");
	public By LOGIN = By.xpath("//*[text()=' LOGIN']");
	public By password = By.id("Password");
	public By Login = By.name("login");
	public By Dasgboard = By.xpath("(//*[text()='Dashboard'])[2]");
	public By LogOut = By.xpath("//*[text()='Log out']");
	public By LoginFailed = By.xpath("//*[text()='Wrong username or password']");
	public By BlankUserNameErrorMessage = By.xpath("//*[text()='Please enter username']");
	public String UserNameBlankMessage = "Please enter username";
	public String loginButtonText = " LOGIN";
	public String dashBoardText = "Dashboard";
	public String incorrectCredentials = "Wrong username or password";
}
