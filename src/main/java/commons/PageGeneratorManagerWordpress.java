package commons;

import org.openqa.selenium.WebDriver;

import wordpress.pageObject.AdminCreatePostPageObject;
import wordpress.pageObject.AdminHomePageObject;
import wordpress.pageObject.AdminPostPageObject;
import wordpress.pageObject.AdminUpdatePostPageObject;
import wordpress.pageObject.LoginPageObject;
import wordpress.pageObject.PostPageObject;

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

	public AdminPostPageObject getAdminPostPage(WebDriver driver) {
		return new AdminPostPageObject(driver);
	}

	public AdminCreatePostPageObject getAdminCreatePostPage(WebDriver driver) {
		return new AdminCreatePostPageObject(driver);
	}

	public PostPageObject getPostPage(WebDriver driver) {
		return new PostPageObject(driver);
	}

	public AdminUpdatePostPageObject getAdminUpdatePostPage(WebDriver driver) {
		return new AdminUpdatePostPageObject(driver);
	}
}
