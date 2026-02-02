package bdd.steps;

import bdd.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class SearchSteps {

    private SearchPage searchPage;

    @Given("I am on the Search page")
    public void i_am_on_the_search_page() {
        Hooks.driver.get("https://www.google.com");
        searchPage = new SearchPage(Hooks.driver);
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        searchPage.enterSearchQuery(query);
        searchPage.submitSearch();
    }

    @Then("I should see results containing {string}")
    public void i_should_see_results_containing(String text) {
        assertTrue(searchPage.areResultsDisplayed());
    }
}
