package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerWordpress;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import wordpress.pageObject.AdminHomePageObject;
import wordpress.pageObject.LoginPageObject;

public class CommonSteps extends BaseTest {
	WebDriver driver;
	LoginPageObject login;
	AdminHomePageObject admin;
	
	public CommonSteps() {
		driver = Hooks.openAndQuitBrowser();
		login=PageGeneratorManagerWordpress.getPageGenerator().getLoginPage(driver);
	}
	
	@When("^Login admin account$")
	public void loginAsAdmin() {
		login.openBrowser(driver, GlobalConstants.WORDPRESS_LOGIN_PAGE_URL);
		login.inputUsername("Thuc Nguyen");
		login.inputPassword("Test@123");
		admin = login.clickLoginButton();
	}
	
	@Then("^Click logout button$")
	public void clickLogoutButton() {
		admin.clickLogOutButton();
	}
	
}
