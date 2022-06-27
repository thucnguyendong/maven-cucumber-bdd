package commons;

import org.openqa.selenium.WebDriver;

import wordpress.pages.AdminHomePageObject;
import wordpress.pages.LoginPageObject;

public class PageGeneratorManagerWordpress {
	public static PageGeneratorManagerWordpress getPageGenerator() {
		return new PageGeneratorManagerWordpress();
	}

	public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
}
