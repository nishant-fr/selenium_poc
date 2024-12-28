package Steps;

import Pages.LoginPage;
import Pages.PageObjectManager;
import Utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResetPasswordPageSteps extends BaseStep{

    private static final Logger log = LoggerFactory.getLogger(ResetPasswordPageSteps.class);
    private ScenarioContext scenarioContext;

    public ResetPasswordPageSteps(Hooks hooks, ScenarioContext scenarioContext){
        this.driver = hooks.driver;
        this.scenarioContext = scenarioContext;
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        resetPasswordPage = pageObjectManager.getResetPasswordPage();
    }

    @When("the user enters a valid email address")
    public void the_user_enters_a_valid_email_address() {
        resetPasswordPage.enterResetUserID("reset@test.com");
    }

    @When("clicks the {string} button in reset password page")
    public void clicks_the_button_in_reset_password_page(String buttonName) {
        log.info("Clicking on the button -> {}", buttonName);
        resetPasswordPage.clickSendResetLink();
    }

    @Then("a confirmation message {string} should be displayed")
    public void a_confirmation_message_should_be_displayed(String confirmationMessage) {
        assertThat(loginPage.isAlertMessageDisplayed(confirmationMessage)).withFailMessage("Confirmation message was not visible").isTrue();
    }

    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() {
        resetPasswordPage.enterResetUserID("reset@test");
    }

    @When("the user enters an unregistered email address")
    public void the_user_enters_an_unregistered_email_address() {
        resetPasswordPage.enterResetUserID("unregistered@test.com");
    }

    @When("the user leaves the email field empty under reset password page")
    public void the_user_leaves_the_email_field_empty_under_reset_password_page() {
        resetPasswordPage.enterResetUserID("");
    }

    @When("the user clicks the LOGIN link at the top under reset password page")
    public void the_user_clicks_the_login_link_at_the_top_under_reset_password_page() {
        resetPasswordPage.clickLoginBarLink();
    }
    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        assertThat(loginPage.isLoginPageDisplayed()).withFailMessage("Login page not visible").isTrue();
    }

    @When("the user clicks the REGISTER link at the top under reset password page")
    public void the_user_clicks_the_register_link_at_the_top_under_reset_password_page() {
       resetPasswordPage.clickRegisterBarLink();
    }
}
