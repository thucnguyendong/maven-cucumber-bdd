package wordpress.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerWordpress;
import wordpress.pageUI.AdminUpdatePostPageUI;

public class AdminUpdatePostPageObject extends BasePage {
	
	private WebDriver driver;
	
	public AdminUpdatePostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickUpdateButton() {
		waitForElementClickable(driver, AdminUpdatePostPageUI.UPDATE_BUTTON);
		clickElement(driver, AdminUpdatePostPageUI.UPDATE_BUTTON);
	}

	public Boolean isPostUpdatedMesDisplay() {
		return isElementDisplayed(driver, AdminUpdatePostPageUI.POST_UPDATED_LABEL);		
	}

	public PostPageObject clickViewPostLink() {
		waitForElementClickable(driver, AdminUpdatePostPageUI.VIEW_POST_LINK);
		clickElement(driver, AdminUpdatePostPageUI.VIEW_POST_LINK);
		return PageGeneratorManagerWordpress.getPageGenerator().getPostPage(driver);
	}	
}
