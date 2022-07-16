package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import commons.PageGeneratorManagerWordpress;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import wordpress.pageObject.AdminCreatePostPageObject;
import wordpress.pageObject.AdminHomePageObject;
import wordpress.pageObject.AdminPostPageObject;
import wordpress.pageObject.AdminUpdatePostPageObject;
import wordpress.pageObject.LoginPageObject;
import wordpress.pageObject.PostPageObject;

public class WordpressPostSteps extends BaseTest {
	WebDriver driver;
	LoginPageObject login;
	AdminHomePageObject adminHomePage;
	AdminPostPageObject adminPostPage;
	AdminCreatePostPageObject createPostPage;
	PostPageObject postPage;
	AdminUpdatePostPageObject updatePostPage;
	
	public WordpressPostSteps() {
		driver = Hooks.openAndQuitBrowser();
		login=PageGeneratorManagerWordpress.getPageGenerator().getLoginPage(driver);
		adminHomePage = PageGeneratorManagerWordpress.getPageGenerator().getAdminHomePage(driver);
		createPostPage = PageGeneratorManagerWordpress.getPageGenerator().getAdminCreatePostPage(driver);
		postPage = PageGeneratorManagerWordpress.getPageGenerator().getPostPage(driver);
		updatePostPage = PageGeneratorManagerWordpress.getPageGenerator().getAdminUpdatePostPage(driver);
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
	
	@Then("^Post with content \"([^\"]*)\" display$")
	public void postWithContentDisplay(String content){
		Assert.assertEquals(postPage.getPostContent(),content);	    
	}
	
	@When("^Click edit post with title \"([^\"]*)\"$")
	public void clickEditPostWithTitle(String title) {
	    updatePostPage = adminPostPage.clickEditButtonByTitle(title);	    
	}

	@When("^Click Update button$")
	public void clickUpdateButton() {
		updatePostPage.clickUpdateButton();	    
	}

	@Then("^Message Post updated display$")
	public void messagePostUpdatedDisplay() {
		assertTrue(updatePostPage.isPostUpdatedMesDisplay());	    
	}

	@Then("^Click View Post link on message$")
	public void clickViewPostLinkOnMessage() {
		postPage= updatePostPage.clickViewPostLink();	    
	}
}
