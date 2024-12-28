package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResetPasswordPage {

    private static final Logger log = LoggerFactory.getLogger(ResetPasswordPage.class);
    private WebDriver driver;
    private WaitHelper wait;

    @FindBy(xpath = "//button[@type='button' and text()='Send Reset Link']")
    private WebElement resetPasswordButton;


    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Email Address']//..//..//..//input[@type='text']")
    private WebElement usernameInput;

    public void enterResetUserID(String username) {
        log.info("Entering user id {}", username);
        wait.waitUntilElementIsVisible(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void clickSendResetLink(){
        wait.waitUntilElementIsVisible(resetPasswordButton);
        resetPasswordButton.click();
    }

    @FindBy(xpath = "//header//button[text()='Login']")
    private WebElement loginBarLink;

    public void clickLoginBarLink() {
        wait.waitUntilElementIsVisible(loginBarLink);
        loginBarLink.click();
    }

    @FindBy(xpath = "//header//button[text()='Register']")
    private WebElement registerBarLink;

    public void clickRegisterBarLink() {
        wait.waitUntilElementIsVisible(registerBarLink);
        registerBarLink.click();
    }


}