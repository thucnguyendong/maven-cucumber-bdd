package wordpress.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerWordpress;
import wordpress.pageUI.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogoutButtonDisplay() {
		moveToElement(driver, AdminHomePageUI.MY_ACCOUNT_TAB);
		return isElementDisplayed(driver, AdminHomePageUI.LOGOUT_BUTTON);
	}

	public AdminPostPageObject clickLeftMenuByItemText(String itemText) {
		waitForElementClickable(driver, AdminHomePageUI.DYNAMIC_MENU_ITEM_BY_TEXT,itemText);
		clickElement(driver, AdminHomePageUI.DYNAMIC_MENU_ITEM_BY_TEXT,itemText);
		return PageGeneratorManagerWordpress.getPageGenerator().getAdminPostPage(driver);
	}

	public void clickLogOutButton() {
		moveToElement(driver, AdminHomePageUI.MY_ACCOUNT_TAB);
		waitForElementClickable(driver, AdminHomePageUI.LOGOUT_BUTTON);
		clickElement(driver, AdminHomePageUI.LOGOUT_BUTTON);
	}
	
}
