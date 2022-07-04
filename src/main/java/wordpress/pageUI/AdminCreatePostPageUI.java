package wordpress.pageUI;

public class AdminCreatePostPageUI {
	public static final String TITLE_TEXTBOX = "//h1[@aria-label='Add title']";
	public static final String CONTENT_TEXTAREA = "//p[@data-title='Paragraph']";
	public static final String DYNAMIC_HEADER_BY_TEXT = "//li/button[@data-label='%s']";
	public static final String NEW_TAG_TEXTBOX = "//label[text()='Add New Tag']//following-sibling::div/input";
	public static final String DYNAMIC_CATEGORY_CHECKBOX_BY_TEXT = "//div[@aria-label='Categories']//label[text()='%s']";
	public static final String PUBLISH_BUTTON = "//div[@class='edit-post-header__settings']//button[text()='Publish']";
	public static final String CONFIRM_PUBLISH_BUTTON = "//div[@class='editor-post-publish-panel__header']//button[text()='Publish']";
	public static final String VIEW_POST_BUTTON = "//div[@class='post-publish-panel__postpublish-buttons']/a[text()='View Post']";
	public static final String DYNAMIC_SECTION_BUTTON_BY_TEXT = "//h2[@class='components-panel__body-title']//button[text()='%s']";
}
