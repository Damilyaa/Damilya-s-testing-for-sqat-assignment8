Feature: Login
  As a user
  I want to log into the system
  So that I can access protected functionality

  Scenario: Successful login with valid credentials
    Given I am on the Login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be logged in successfully
