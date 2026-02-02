Feature: Web Tables editing
  As a user
  I want to edit an existing row in Web Tables
  So that the updated data is saved in the table

  Scenario: Edit user data in Web Tables
    Given I am on the Web Tables page
    When I edit the user with email "cierra@example.com" and set first name "Damilya" last name "Amangeldykyzy" age "20"
    Then the table first name for email "cierra@example.com" should be "Damilya"
