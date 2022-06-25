package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import Locators.CustomerDetailsPageLocators;
import Utilities.BaseClass;
import io.cucumber.java.en.And;

public class CustomerPageStepDefinition {
	
	CustomerDetailsPageLocators cdpl = new CustomerDetailsPageLocators();
	
	BaseClass bs = new BaseClass();
	
	@And("^I click on Edit for customer no. (.*)$")
	public void I_click_on_Edit_for_customer_no_(String customerNumber) {
		bs.clickElement(By.xpath("(//a[text()='Edit'])"+"["+customerNumber+"]"));
	}
	
	@And("^I verify Edit page is launched$")
	public void I_verify_Edit_page_is_launched() {
		Assert.assertEquals(bs.getText(cdpl.verifyEditText).trim(), "Edit".trim());
	}
	
	@And("^I edit (.*) as (.*)$")
	public void I_enter_customer_details(String locator, String input) {
		bs.sendInput(By.id(locator), input);
	}
	
	@And("^I click on Save button$")
	public void  I_click_on_Save_button() {
		bs.clickElement(cdpl.saveButton);
	}
	
	@And("^I verify customer details edited successfully for customer (.*)$")
	public void I_verify_customer_details_edited(String name) {
		Assert.assertEquals(bs.getText(By.xpath("//td[contains(text(),'"+name.trim()+"')]")).trim(), name.trim());
	}
}
