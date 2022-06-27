package wordpress.pages;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerWordpress;
import wordpress.interfaces.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputUsername(String username) {
		inputToTextboxByID(driver, "user_login", username);
		
	}

	public void inputPassword(String password) {
		inputToTextboxByID(driver, "user_pass", password);
	}
	
	public AdminHomePageObject clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickElement(driver, LoginPageUI.LOGIN_BUTTON);
		areJQueryAndJSLoadedSuccess(driver);
		return PageGeneratorManagerWordpress.getPageGenerator().getAdminHomePage(driver);
	}

	public String getErrorText() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_ERROR_TEXT);
		return getElementText(driver, LoginPageUI.LOGIN_ERROR_TEXT);
	}
	
}
