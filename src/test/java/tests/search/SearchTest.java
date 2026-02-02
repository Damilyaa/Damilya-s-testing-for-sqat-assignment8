package tests.search;

import base.BaseTestSearch;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTestSearch {

    @Test
    public void testGoogleSearch() {
        searchPage.enterSearchQuery("Selenium WebDriver");
        searchPage.submitSearch();

        assertTrue(
                searchPage.areResultsDisplayed(),
                "Search results were not displayed"
        );
    }
}
