Feature: Login
  As a user
  I want to log into the system
  So that I can access protected functionality

  Scenario: Successful login with valid credentials
    Given I am on the Login page
    When I login with username "valid_user" and password "valid_password"
    Then I should be logged in successfully
