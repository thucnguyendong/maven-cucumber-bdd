package wordpress.pages;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import wordpress.interfaces.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogoutButtonDisplay() {
		moveToElement(driver, AdminHomePageUI.MY_ACCOUNT_TAB);
		return isElementDisplayed(driver, AdminHomePageUI.LOGOUT_BUTTON);
	}

}
