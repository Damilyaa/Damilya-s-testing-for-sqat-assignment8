package bdd.steps;

import bdd.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.elements.ElementsPage;
import pages.elements.WebTablesPage;

public class WebTablesSteps {

    private HomePage homePage;
    private WebTablesPage webTablesPage;

    @Given("I am on the Web Tables page")
    public void i_am_on_the_web_tables_page() {
        homePage = new HomePage(Hooks.driver);
        Hooks.driver.get("https://demoqa.com");

        ElementsPage elementsPage = homePage.goToElements();
        webTablesPage = elementsPage.clickWebTables();
    }

    @When("I edit the user with email {string}")
    public void i_edit_the_user_with_email(String email) {
        webTablesPage.clickEditButton(email);
    }

    @When("I set first name {string} last name {string} age {string}")
    public void i_set_first_name_last_name_age(
            String firstName, String lastName, String age) {

        webTablesPage.setFirstName(firstName);
        webTablesPage.setLastName(lastName);
        webTablesPage.setAge(age);
        webTablesPage.clickSubmitButton();
    }


    @Then("the table first name for email {string} should be {string}")
    public void the_table_first_name_for_email_should_be(String email, String expectedFirstName) {

        String actual = webTablesPage.getTableFirstName(email);
        org.testng.Assert.assertEquals(actual, expectedFirstName,
                "First name in table does not match expected value");
    }

}
