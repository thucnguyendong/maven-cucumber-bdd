@wordpressLogin
Feature: Title of your feature
  I want to use this template for my feature file

  @loginInvalidPassword
  Scenario: Verify login page
    Given Open wordpress login page
    When Input username "Thuc Nguyen"
    And Input password "Test"
    And Click login button
    Then Verify error message: incorrect password
    
 	@loginNotRegisteredUser
  Scenario: Verify login page
    Given Open wordpress login page
    When Input username and password
    |Username|Test|
    |Password|Test|
    And Click login button
    Then Verify error message: not registered

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
      | Thuc Nguyen | test     | Error: The password you entered for the username Thuc Nguyen is incorrect. Lost your password?                               | 
