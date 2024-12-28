package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import Drivers.DriverManager;

public class LoginSteps {

    private WebDriver driver = DriverManager.getDriver();
    private LoginPage loginPage;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver.get("http://localhost:8090/login");
        loginPage = new LoginPage(driver); // Initialize the LoginPage
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {

    }
    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertEquals("React App", driver.getTitle());
    }
}
