package wordpress.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerWordpress;
import wordpress.pageUI.AdminPostPageUI;

public class AdminPostPageObject extends BasePage {
	
	private WebDriver driver;
	
	public AdminPostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminCreatePostPageObject clicAddNewButton() {
		waitForElementClickable(driver, AdminPostPageUI.ADD_NEW_BUTTON);
		clickElement(driver, AdminPostPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManagerWordpress.getPageGenerator().getAdminCreatePostPage(driver);
	}
	
}
