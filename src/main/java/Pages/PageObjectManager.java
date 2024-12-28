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
}
