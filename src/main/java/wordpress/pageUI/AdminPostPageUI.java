package wordpress.pageUI;

public class AdminPostPageUI {
	public static final String ADD_NEW_BUTTON = "//a[@class='page-title-action']";
	public static final String DYNAMIC_TITLE_BY_TEXT = "//a[@class='row-title' and text()='%s']";
	public static final String DYNAMIC_EDIT_BUTTON_BY_TITLE = "//a[@class='row-title' and text()='%s']/..//following-sibling::div/span[@class='edit']";
}
