@CreateUpdateAndDownloadPost
Feature: Create, edit and delete post
  I want to create, edit and delete post

	@CreatePost
  Scenario Outline: Create new post
    Given Login admin account
     When Navigate to Posts page
      And Click Add New
      And Input title "<title>" 
      And Input content "<content>"
      And Select category "<category>"
      And Input tag "<tag>"
      And Click Publish
      And Click Confirm Publish      
      And Click View Post
      Then Post with title "<title>" display 
      And Post with content "<content>" display 
      And Click logout button
  
    Examples: 
      | title   | content        | category | tag  | 
      | Testing | I am too tired | Selenium | Test | 
      
  @EditPost
  Scenario Outline: Edit post
    Given Login admin account
     When Navigate to Posts page
      And Click edit post with title "<title>"
      And Input title "<new title>" 
      And Input content "<content>"
      And Input tag "<tag>"
      And Click Update button
      Then Message Post updated display
      And Click View Post link on message
      And Post with title "<new title>" display
      And Post with content "<content>" display 
      And Click logout button
  
    Examples: 
      | title   | content        | category | tag  | new title |
      | Testing | I am QC Engineer | Uncategorized | QC | Thuc Nguyen |