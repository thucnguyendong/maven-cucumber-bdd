package commons;

import org.openqa.selenium.WebDriver;
import wordpress.pages.UserLoginPageObject;

public class PageGeneratorManagerWordpress {
	public static PageGeneratorManagerWordpress getPageGenerator() {
		return new PageGeneratorManagerWordpress();
	}

	public UserLoginPageObject getUserHomePage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
}
