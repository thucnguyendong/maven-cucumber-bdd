@wordpress
Feature: Title of your feature
  I want to use this template for my feature file

  @loginInvalidPassword
  Scenario: Verify login page
    Given Login wordpress successfully
    When Input username
    And Input password
    And Click login button
    Then Verify error message

