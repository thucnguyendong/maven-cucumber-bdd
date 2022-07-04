@CreateAndUpdatePost
Feature: Create and edit new post
  I want to create and edit new post

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
      And Post with title "<title>" display
  
    Examples: 
      | title   | content        | category | tag  | 
      | Testing | I am too tired | Selenium | Test | 