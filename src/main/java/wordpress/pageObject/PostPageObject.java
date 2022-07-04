package wordpress.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import wordpress.pageUI.PostPageUI;

public class PostPageObject extends BasePage {
	
	private WebDriver driver;
	
	public PostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPostTitle() {
		waitForElementVisible(driver, PostPageUI.TITLE_TEXT);
		return getElementText(driver, PostPageUI.TITLE_TEXT);
	}

}
