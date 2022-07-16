package wordpress.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerWordpress;
import wordpress.pageUI.AdminCreatePostPageUI;

public class AdminCreatePostPageObject extends BasePage {
	
	private WebDriver driver;
	
	public AdminCreatePostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputTitleTextbox(String title) {
		waitForElementVisible(driver, AdminCreatePostPageUI.TITLE_TEXTBOX);
		inputIntoElement(driver, AdminCreatePostPageUI.TITLE_TEXTBOX, title);
		sendKeyboardToElement(driver, AdminCreatePostPageUI.TITLE_TEXTBOX, Keys.TAB);
	}

	public void inputContentTextarea(String content) {
		clearTextByKeyboard(driver, AdminCreatePostPageUI.CONTENT_TEXTAREA);
		inputIntoElement(driver, AdminCreatePostPageUI.CONTENT_TEXTAREA, content);
	}

	public void inputNewTagTextbox(String tag) {
		waitForElementVisible(driver, AdminCreatePostPageUI.NEW_TAG_TEXTBOX);
		clickElement(driver, AdminCreatePostPageUI.CONTENT_TEXTAREA);
		inputIntoElement(driver, AdminCreatePostPageUI.NEW_TAG_TEXTBOX, tag);
	}


	public void checkCategoriesByText(String category) {
		checkToDefaultCheckboxRadio(driver, AdminCreatePostPageUI.DYNAMIC_CATEGORY_CHECKBOX_BY_TEXT, category);
	}


	public void clickPublishButton() {
		waitForElementVisible(driver, AdminCreatePostPageUI.PUBLISH_BUTTON);
		clickElement(driver, AdminCreatePostPageUI.PUBLISH_BUTTON);			
	}

	public void clickHeaderByText(String header) {
		waitForElementVisible(driver, AdminCreatePostPageUI.DYNAMIC_HEADER_BY_TEXT,header);
		clickElement(driver, AdminCreatePostPageUI.DYNAMIC_HEADER_BY_TEXT, header);		
	}

	public void clickConfirmPublishButton() {
		waitForElementVisible(driver, AdminCreatePostPageUI.CONFIRM_PUBLISH_BUTTON);
		clickElement(driver, AdminCreatePostPageUI.CONFIRM_PUBLISH_BUTTON);	
	}

	public PostPageObject clickViewPostButton() {
		waitForElementVisible(driver, AdminCreatePostPageUI.VIEW_POST_BUTTON);
		clickElement(driver, AdminCreatePostPageUI.VIEW_POST_BUTTON);	
		return PageGeneratorManagerWordpress.getPageGenerator().getPostPage(driver);
	}

	public void expandSectionByText(String sectionText) {
		if(getElementAttribute(driver, AdminCreatePostPageUI.DYNAMIC_SECTION_BUTTON_BY_TEXT, "aria-expanded",sectionText).equals("false"))
			clickElement(driver, AdminCreatePostPageUI.DYNAMIC_SECTION_BUTTON_BY_TEXT,sectionText);			
	}
}
