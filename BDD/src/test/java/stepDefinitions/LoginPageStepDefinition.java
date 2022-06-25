package stepDefinitions;

import Locators.LoginPageLocators;
import Utilities.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class LoginPageStepDefinition {

	BaseClass bs = new BaseClass();

	LoginPageLocators loginPageLocators = new LoginPageLocators();

	@Given("^I click on Login button on Home Page$")
	public void I_click_on_Login_button_on_home_page() {
		bs.clickElement(loginPageLocators.LoginButtonHomePage);
	}

	@And("^I verify login form is launched$")
	public void I_verify_login_form_is_launched() {
		Assert.assertEquals(bs.getText(loginPageLocators.LOGIN).trim(), (loginPageLocators.loginButtonText).trim());
		}

	@And("^I click on Login button$")
	public void I_click_on_Login_button() {
		bs.clickElement(loginPageLocators.Login);
	}

	@And("^I verify my login is successful$")
	public void I_verify_my_login_is_successful() {
		Assert.assertEquals(bs.getText(loginPageLocators.Dasgboard), loginPageLocators.dashBoardText);
		}

	@And("^I verify my login is unsuccessful$")
	public void I_verify_my_login_is_unsuccessful() {
		Assert.assertEquals(bs.getText(loginPageLocators.LoginFailed), loginPageLocators.incorrectCredentials);
		}

	@And("^I click on logout button$")
	public void I_click_on_logout_button() {
		bs.clickElement(loginPageLocators.LogOut);
	}

	@And("^I verify logout was successful$")
	public void I_verify_logout_was_successful() {
		Assert.assertEquals(bs.getText(loginPageLocators.LOGIN).trim(), loginPageLocators.loginButtonText.trim());
	}

	@And("^I verify blank Username message is shown$")
	public void I_verify_blank_Username_message_is_shown() {
		Assert.assertEquals(bs.getText(loginPageLocators.BlankUserNameErrorMessage), loginPageLocators.UserNameBlankMessage);
	}

}
