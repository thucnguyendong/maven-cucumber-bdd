@wordpressLogin
Feature: Login
  I want to check login flow: login successfully and failed to login

	@loginAllError
  Scenario Outline: Verify all error of login page
    Given Open wordpress login page
     When Input username "<username>"
      And Input password "<password>"
      And Click login button
     Then Verify error "<message>"
  
    Examples: 
      | username    | password | message                                                                                                                      | 
      | Thuc Nguyen |          | Error: The password field is empty.                                                                                          | 
      |             | test     | Error: The username field is empty.                                                                                          | 
      | Test        | test     | Error: The username Test is not registered on this site. If you are unsure of your username, try your email address instead. | 
      | Thuc Nguyen | test     | Error: The password you entered for the username Thuc Nguyen is incorrect. Lost your password?																|
      
  @loginAdminSuccessfully
  Scenario: Verify login page
    Given Open wordpress login page
     When Input username and password
      | Username | Thuc Nguyen | 
      | Password | Test@123    | 
      And Click login button
     Then Verify logout button display