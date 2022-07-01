@CreateAndUpdatePost
Feature: Create and edit new post
  I want to create and edit new post

  Scenario Outline: Create new post
    Given Open admin page
     When Navigate to Posts page
      And Click Add New
      And Input "<title>" 
      And Input "<content>"
      And Select "<category>"
      And Input "<tag>"
      And Click Publish     
     Then Message with "<title>" display
      And Click View Post
      And Post with "<title>" display
  
    Examples: 
      | title   | content        | category | tag  | 
      | Testing | I am too tired | Selenium | Test | 