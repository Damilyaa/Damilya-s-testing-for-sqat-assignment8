Feature: Search
  As a user
  I want to search for items
  So that I can find relevant results

  Scenario: Search returns results
    Given I am on the Search page
    When I search for "selenium"
    Then I should see results containing "selenium"
