package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private WebDriver driver;
    private WaitHelper wait;

    @FindBy(id = ":r0:")
    private WebElement usernameInput;

    @FindBy(id = ":r1:")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit' and text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'MuiBox-root')]//button[@type='button' and text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[text()='Forgot Password?']")
    private WebElement forgotPasswordLink;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage(){
        log.info("Navigating to the application URL");
        driver.get("http://localhost:8090/login");
    }

    @FindBy(xpath = "//h4[text()='Login']")
    private WebElement loginHeaderElement;
    public boolean isLoginPageDisplayed(){
        wait.waitUntilElementIsVisible(loginHeaderElement);
        return loginHeaderElement.isDisplayed();
    }

    public void enterUsername(String username) {
        log.info("Entering user name {}", username);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        log.info("Entering user password {}", password);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        log.info("Clicking on Login Button");
        wait.waitUntilElementIsVisible(loginButton);
        loginButton.click();
    }

    public void clickRegisterButton() {
        log.info("Clicking on Register Button");
        wait.waitUntilElementIsVisible(registerButton);
        registerButton.click();
    }

    @FindBy(xpath = "//h1[text()='Profile']")
    private WebElement profileHeader;

    public boolean isProfilePageVisible(){
        wait.waitUntilElementIsVisible(profileHeader);
        return profileHeader.isDisplayed();
    }

    @FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
    private WebElement alertMessageElement;

    public boolean isAlertMessageDisplayed(String alertMessage){
        wait.waitUntilElementIsVisible(alertMessageElement);
        return alertMessageElement.getText().contains(alertMessage);
    }

    @FindBy(xpath = "//h1[text()='Register']")
    private WebElement registerHeaderElement;
    public boolean isRegisterPageDisplayed(){
        wait.waitUntilElementIsVisible(registerHeaderElement);
        return registerHeaderElement.isDisplayed();
    }

    public void clickForgotPasswordLink(){
        wait.waitUntilElementIsVisible(forgotPasswordLink);
        forgotPasswordLink.click();
    }

    @FindBy(xpath = "//h1[text()='Reset Password']")
    private WebElement forgotPasswordHeader;

    public boolean isForgotPasswordPageVisible(){
        wait.waitUntilElementIsVisible(forgotPasswordHeader);
        return forgotPasswordHeader.isDisplayed();
    }
}
