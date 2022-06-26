package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerWordpress;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wordpress.pages.UserLoginPageObject;

public class wordpressLoginSteps extends BaseTest {
	WebDriver driver;
	UserLoginPageObject login;
	
	@Given("^Open wordpress login page$")
	public void openWordpressLoginPage() {
	    driver =getBrowserDriver("chrome", GlobalConstants.WORDPRESS_LOGIN_PAGE_URL);
	    login=PageGeneratorManagerWordpress.getPageGenerator().getUserLoginPage(driver);
	}
	
	@When("^Input username \"([^\"]*)\"$")
	public void inputUsername(String username) {
	    login.inputUsername(username);
	}

	@And("^Input password \"([^\"]*)\"$")
	public void inputPassword(String password) {
		login.inputPassword(password);	    
	}

	@And("^Click login button$")
	public void clickLoginButton() {
	    login.clickLoginButton();	    
	}

	@Then("^Verify error message: incorrect password$")
	public void verifyIncorrectPasswordErrorMessage() {
	    Assert.assertEquals(login.getErrorText(),"Error: The password you entered for the username Thuc Nguyen is incorrect. Lost your password?");
	    closeBrowserAndDriver();
	}
	
	@When("^Input username and password$")
	public void inputUsernameAndPassword(DataTable table) {
		Map<String, String> loginValue = table.asMap(String.class, String.class);
		login.inputUsername(loginValue.get("Username"));
		login.inputPassword(loginValue.get("Password"));
	}

	@Then("^Verify error message: not registered$")
	public void verifyNotRegisteredErrorMessage() {
	    Assert.assertEquals(login.getErrorText(),"Error: The username Test is not registered on this site. If you are unsure of your username, try your email address instead.");
	    closeBrowserAndDriver();
	}
	
	@Then("^Verify error \"([^\"]*)\"$")
	public void verifyError(String message) {
		Assert.assertEquals(login.getErrorText(),message);
	    closeBrowserAndDriver();
	}
}
