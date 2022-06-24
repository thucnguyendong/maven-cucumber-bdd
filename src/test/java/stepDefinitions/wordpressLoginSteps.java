package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerWordpress;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wordpress.pages.UserLoginPageObject;

public class wordpressLoginSteps extends BaseTest {
	WebDriver driver;
	UserLoginPageObject login;
	
	String username= "Thuc Nguyen";
	String password= "Test";
	
	@Given("^Login wordpress successfully$")
	public void loginWordpressSuccessfully()  {
		log.info("Pre-condition: Open browser chrome and navigate to "+ GlobalConstants.WORDPRESS_LOGIN_PAGE_URL);
		driver = getBrowserDriver("chrome",GlobalConstants.WORDPRESS_LOGIN_PAGE_URL);
		login = PageGeneratorManagerWordpress.getPageGenerator().getUserHomePage(driver);
	}

	@When("^Input username$")
	public void inputUsername()  {
	    login.inputUsername(username);	  
	}

	@And("^Input password$")
	public void inputPassword()  {
	    login.inputPassword(password);   
	}

	@And("^Click login button$")
	public void clickLoginButton()  {
		login.clickLoginButton();	    
	}

	@Then("^Verify error message$")
	public void verifyErrorMessage()  {
		assertEquals(login.getErrorText(),"Error: The password you entered for the username Thuc Nguyen is incorrect. Lost your password?");
		driver.quit();
	}
}
