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
import cucumberOptions.Hooks;
import wordpress.pageObject.AdminHomePageObject;
import wordpress.pageObject.LoginPageObject;

public class WordpressLoginSteps extends BaseTest {
	WebDriver driver;
	LoginPageObject login;
	AdminHomePageObject admin;
	static String username,pass;
	
	public WordpressLoginSteps() {
		driver = Hooks.openAndQuitBrowser();
		login=PageGeneratorManagerWordpress.getPageGenerator().getLoginPage(driver);
	}
	
	
	@Given("^Open wordpress login page$")
	public void openWordpressLoginPage() {
		login.openBrowser(driver, GlobalConstants.WORDPRESS_LOGIN_PAGE_URL);
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
		admin = login.clickLoginButton();	    
	}
	
	@When("^Input username and password$")
	public void inputUsernameAndPassword(DataTable table) {
		Map<String, String> loginValue = table.asMap(String.class, String.class);
		username = loginValue.get("Username");
		login.inputUsername(username);
		pass = loginValue.get("Password");
		login.inputPassword(pass);
	}
	
	@Then("^Verify error \"([^\"]*)\"$")
	public void verifyError(String message) {
		Assert.assertEquals(login.getErrorText(),message);
	}
	
	@Then("^Verify logout button display$")
	public void verifyLogoutButtonDisplay() {
		Assert.assertTrue(admin.isLogoutButtonDisplay());
	}
}
