package Steps;

import Pages.LoginPage;
import Pages.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    public WebDriver driver = null;
    protected LoginPage loginPage;
    protected PageObjectManager pageObjectManager;

    protected PageObjectManager getPageObjectManager(WebDriver driver) {
        if (pageObjectManager == null) return new PageObjectManager(driver);
        return pageObjectManager;
    }
}