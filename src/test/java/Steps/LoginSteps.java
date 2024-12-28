package Steps;

import Pages.LoginPage;
import Pages.PageObjectManager;
import Utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSteps extends BaseStep{

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private ScenarioContext scenarioContext;

    public LoginSteps(Hooks hooks, ScenarioContext scenarioContext){
        this.driver = hooks.driver;
        this.scenarioContext = scenarioContext;
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertEquals("React App", driver.getTitle());
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.openLoginPage();

    }

    @When("the user enters a valid email and password")
    public void the_user_enters_a_valid_email_and_password() {
        loginPage.enterUsername("selenium@test.com");
        loginPage.enterPassword("selenium2025!");
    }

    @When("clicks the {string} button")
    public void clicks_the_button(String buttonName) {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        assertThat(loginPage.isProfilePageVisible()).withFailMessage("Profile Page was not visible").isTrue();
    }

    @When("the user enters an invalid email or password")
    public void the_user_enters_an_invalid_email_or_password() {
        loginPage.enterUsername("selenium@test");
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String alertMessage) {
        assertThat(loginPage.isAlertMessageDisplayed(alertMessage)).withFailMessage("Alert message was not visible").isTrue();
    }

    @Then("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        assertThat(loginPage.isLoginPageDisplayed()).withFailMessage("Login page not visible").isTrue();
    }

    @When("the user leaves the email field empty")
    public void the_user_leaves_the_email_field_empty() {
        loginPage.enterUsername("");
    }

    @When("enters a password")
    public void enters_a_password() {
        loginPage.enterPassword("selenium2025!");
    }

    @Then("the user should see a validation message {string}")
    public void the_user_should_see_a_validation_message(String validationMessage) {
        the_user_should_see_an_error_message(validationMessage);
    }

    @When("the user enters an email")
    public void the_user_enters_an_email() {
        loginPage.enterUsername("selenium@test.com");
    }

    @When("leaves the password field empty")
    public void leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String registerButton) {
        loginPage.clickRegisterButton();
    }

    @Then("the user should be redirected to the registration page")
    public void the_user_should_be_redirected_to_the_registration_page() {
        assertThat(loginPage.isRegisterPageDisplayed()).withFailMessage("Register Page was not visible").isTrue();
    }

    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String link) {
        loginPage.clickForgotPasswordLink();
    }
    @Then("the user should be redirected to the forgot password page")
    public void the_user_should_be_redirected_to_the_forgot_password_page() {
        assertThat(loginPage.isForgotPasswordPageVisible()).withFailMessage("Forgot Password Page was not visible").isTrue();
    }

}
