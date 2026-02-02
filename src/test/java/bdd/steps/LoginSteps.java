package bdd.steps;

import bdd.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {

        // map "valid_*" from feature to real SauceDemo credentials
        if ("valid_user".equals(username)) username = "standard_user";
        if ("valid_password".equals(password)) password = "secret_sauce";

        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }

}
