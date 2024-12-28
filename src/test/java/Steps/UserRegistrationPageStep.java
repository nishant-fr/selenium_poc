package Steps;

import Pages.PageObjectManager;
import Utils.ScenarioContext;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class UserRegistrationPageStep extends BaseStep{

    private static final Logger log = LoggerFactory.getLogger(UserRegistrationPageStep.class);
    private ScenarioContext scenarioContext;
    private Faker faker;

    public UserRegistrationPageStep(Hooks hooks, ScenarioContext scenarioContext){
        this.driver = hooks.driver;
        this.scenarioContext = scenarioContext;
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        userRegistrationPage = pageObjectManager.getUserRegistrationPage();
        faker = new Faker();
    }

    @When("the user enters the following values to register")
    public void the_user_enters_the_following_values_to_register(DataTable userRegistrationValues) {
        String firstName = GetTableValues("firstName", userRegistrationValues);
        String lastName = GetTableValues("lastName", userRegistrationValues);
        String phoneNo = GetTableValues("phoneNo", userRegistrationValues);
        String ssnNo = GetTableValues("ssnNo", userRegistrationValues);
        String bloodType = GetTableValues("bloodType", userRegistrationValues);
        String sex = GetTableValues("sex", userRegistrationValues);
        String dob = GetTableValues("dob", userRegistrationValues);
        String physicianFirstName = GetTableValues("physicianFirstName", userRegistrationValues);
        String physicianLastName = GetTableValues("physicianLastName", userRegistrationValues);
        String physicianTitle = GetTableValues("physicianTitle", userRegistrationValues);
        String careSiteName = GetTableValues("careSiteName", userRegistrationValues);
        String careSiteAddress = GetTableValues("careSiteAddress", userRegistrationValues);
        String emailId = GetTableValues("emailId", userRegistrationValues);
        String password = GetTableValues("password", userRegistrationValues);

        if(firstName.equals("random")) userRegistrationPage.enterFirstName(faker.name().firstName());
        else userRegistrationPage.enterFirstName(firstName);

        if(lastName.equals("random")) userRegistrationPage.enterLastName(faker.name().lastName());
        else userRegistrationPage.enterLastName(lastName);

        userRegistrationPage.enterPhoneName(phoneNo);
        userRegistrationPage.enterSSNValue(ssnNo);
        userRegistrationPage.enterBloodType(bloodType);
        userRegistrationPage.enterSexType(sex);
        userRegistrationPage.enterDOB(dob);

        if(physicianFirstName.equals("random")) userRegistrationPage.enterPhysicianFirstName(faker.name().firstName());
        else userRegistrationPage.enterPhysicianFirstName(physicianFirstName);

        if(physicianLastName.equals("random")) userRegistrationPage.enterPhysicianLastName(faker.name().lastName());
        else userRegistrationPage.enterPhysicianLastName(physicianLastName);

        userRegistrationPage.enterPhysicianTitle(physicianTitle);

        if(careSiteName.equals("random")) userRegistrationPage.enterCareSiteName(faker.company().name());
        else userRegistrationPage.enterCareSiteName(careSiteName);

        if(careSiteAddress.equals("random")) userRegistrationPage.enterCareSiteAddress(faker.address().streetAddress());
        else userRegistrationPage.enterCareSiteAddress(careSiteAddress);

        if(emailId.equals("random")){
            String email = faker.internet().emailAddress();
            userRegistrationPage.enterUserEmail(email);
            scenarioContext.setContext("userID", email);
        }
        else userRegistrationPage.enterUserEmail(emailId);

        if(password.equals("random")){
            String passwordValue = faker.internet().password();
            userRegistrationPage.enterUserPassword(passwordValue);
            scenarioContext.setContext("userPassword", passwordValue);
        } userRegistrationPage.enterUserPassword(password);

    }

    @When("the user clicks the {string} button under registration page")
    public void the_user_clicks_the_button_under_registration_page(String registerButton) {
        userRegistrationPage.clickRegisterButton();
    }

    @Then("upon successfull registration the user is redirected to the login page")
    public void upon_successfull_registration_the_user_is_redirected_to_the_login_page() {
        assertThat(loginPage.isLoginPageDisplayed()).withFailMessage("Login page not visible").isTrue();
    }

    @Then("newly registered user is able to login successfully to the application")
    public void newly_registered_user_is_able_to_login_successfully_to_the_application() {
        String registeredUserID = scenarioContext.getContext("userID").toString();
        String registeredUserPassword = scenarioContext.getContext("userPassword").toString();

        log.info("Registered User ID was found to be {} and Password to be as {}", registeredUserID, registeredUserPassword);
        loginPage.enterUsername(registeredUserID);
        loginPage.enterPassword(registeredUserPassword);
        loginPage.clickLoginButton();

        assertThat(loginPage.isProfilePageVisible()).withFailMessage("Profile Page was not visible").isTrue();
    }

}
