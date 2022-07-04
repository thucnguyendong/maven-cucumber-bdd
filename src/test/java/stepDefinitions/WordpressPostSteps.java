package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import commons.PageGeneratorManagerWordpress;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.junit.Assert;
import wordpress.pageObject.AdminCreatePostPageObject;
import wordpress.pageObject.AdminHomePageObject;
import wordpress.pageObject.AdminPostPageObject;
import wordpress.pageObject.LoginPageObject;
import wordpress.pageObject.PostPageObject;

public class WordpressPostSteps extends BaseTest {
	WebDriver driver;
	LoginPageObject login;
	AdminHomePageObject adminHomePage;
	AdminPostPageObject adminPostPage;
	AdminCreatePostPageObject createPostPage;
	PostPageObject postPage;
	
	public WordpressPostSteps() {
		driver = Hooks.openAndQuitBrowser();
		login=PageGeneratorManagerWordpress.getPageGenerator().getLoginPage(driver);
		adminHomePage = PageGeneratorManagerWordpress.getPageGenerator().getAdminHomePage(driver);
	}
	
	@When("^Navigate to Posts page$")
	public void navigateToPostsPage(){
		adminPostPage=adminHomePage.clickLeftMenuByItemText("Posts");   
	}

	@When("^Click Add New$")
	public void clickAddNew(){
		createPostPage = adminPostPage.clicAddNewButton();	    
	}

	@When("^Input title \"([^\"]*)\"$")
	public void inputTitle(String title){
	    createPostPage.inputTitleTextbox(title);	    
	}
	
	@When("^Input content \"([^\"]*)\"$")
	public void inputContent(String content){
		createPostPage.inputContentTextarea(content);	    
	}
	
	@When("^Input tag \"([^\"]*)\"$")
	public void inputTag(String tag){
		createPostPage.clickHeaderByText("Post");
		createPostPage.expandSectionByText("Tags");
		createPostPage.inputNewTagTextbox(tag);
	    
	}

	@When("^Select category \"([^\"]*)\"$")
	public void select(String category){
		createPostPage.clickHeaderByText("Post");
		createPostPage.expandSectionByText("Categories");
	    createPostPage.checkCategoriesByText(category);	    
	}

	@When("^Click Publish$")
	public void clickPublish(){
		createPostPage.clickPublishButton();	    
	}
	
	@When("^Click Confirm Publish$")
	public void clickConfirmPublish(){
		createPostPage.clickConfirmPublishButton();	    
	}

	@Then("^Click View Post$")
	public void clickViewPost(){
		postPage = createPostPage.clickViewPostButton();		
	}

	@Then("^Post with title \"([^\"]*)\" display$")
	public void postWithTitleDisplay(String title){
		Assert.assertEquals(postPage.getPostTitle(),title);	    
	}
}
