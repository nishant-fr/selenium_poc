package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    private WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private LoginPage loginPage;
    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    private ResetPasswordPage resetPasswordPage;
    public ResetPasswordPage getResetPasswordPage() {
        return (resetPasswordPage == null) ? resetPasswordPage = new ResetPasswordPage(driver) : resetPasswordPage;
    }

    private UserRegistrationPage userRegistrationPage;
    public UserRegistrationPage getUserRegistrationPage() {
        return (userRegistrationPage == null) ? userRegistrationPage = new UserRegistrationPage(driver) : userRegistrationPage;
    }

}
