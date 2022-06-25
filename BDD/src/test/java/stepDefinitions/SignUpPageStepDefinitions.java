package stepDefinitions;

import org.junit.Assert;

import Locators.SignUpPageLocators;
import Utilities.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpPageStepDefinitions {

	BaseClass bs = new BaseClass();

	SignUpPageLocators signUpPageLocators = new SignUpPageLocators();

	@Given("^I am on the homepage of the Itera QA site$")
	public void i_am_on_home_page_of_qa_itera_site() {
	}

	@When("^I click on Sign Up button on homepage$")
	public void i_click_on_sign_up_button_on_homepage() {
		bs.clickElement(signUpPageLocators.SignUp);
	}

	@And("^I verify signup page is launched$")
	public void I_verify_signup_page_is_launched() {
		Assert.assertEquals(bs.getText(signUpPageLocators.SignUpPageText), "Add new user");
	}

	@And("^I enter FirstName as (.*)$")
	public void I_enter_Firstname(String fname) {
		bs.sendInput(signUpPageLocators.FirstName, fname);
	}

	@And("^I enter LastName as (.*)$")
	public void I_enter_Lastname(String lname) {
		bs.sendInput(signUpPageLocators.LastName, lname);
	}

	@And("^I enter Email as (.*)$")
	public void I_enter_E_post(String email) {
		bs.sendInput(signUpPageLocators.Email, email);
	}

	@And("^I enter Mobile as (.*)$")
	public void I_enter_Mobile(String mobile) {
		bs.sendInput(signUpPageLocators.Mobile, mobile);
	}

	@And("^I enter UserName as (.*)$")
	public void I_enter_UserName(String username) {
		bs.sendInput(signUpPageLocators.Username, username);
	}

	@And("^I enter Password as (.*)$")
	public void I_enter_Password(String password) {
		bs.sendInput(signUpPageLocators.Password, password);
	}

	@And("^I enter Confirm Password as (.*)$")
	public void I_enter_Confirm_password(String confPassword) {
		bs.sendInput(signUpPageLocators.ConfirmPassword, confPassword);
	}

	@Then("^I click on Submit button$")
	public void I_click_on_Submit_button() {
		bs.clickElement(signUpPageLocators.Submit);
	}


	@Then("^I verify Registration successful message is shown on the screen$")
	public void I_verify_Regiostration_successful_message_is_shown_on_the_screen() {
		Assert.assertEquals(bs.getText(signUpPageLocators.SuccesfullMessage), signUpPageLocators.registrationSuccess); 
	}


	@Then("^I verify DUplicate UserName message is shown on the screen$")
	public void I_verify_DUplicate_UserName_message_is_shown_on_the_screen() {
		Assert.assertEquals(bs.getText(signUpPageLocators.duplicateUser), signUpPageLocators.UserNameErrorMessage); 
	}

	@Then("^I verify password mismatch message is shown on the screen$")
	public void I_verify_password_mismatch_message_is_shown_on_the_screen() {
		Assert.assertEquals(bs.getText(signUpPageLocators.incorrectPasswordErrorMessage), signUpPageLocators.PasswordErrorMessage); 
	}
}
