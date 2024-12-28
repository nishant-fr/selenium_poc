package Steps;

import Pages.LoginPage;
import Pages.PageObjectManager;
import Pages.ResetPasswordPage;
import Pages.UserRegistrationPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class BaseStep {
    public WebDriver driver = null;
    protected LoginPage loginPage;
    protected ResetPasswordPage resetPasswordPage;
    protected PageObjectManager pageObjectManager;
    protected UserRegistrationPage userRegistrationPage;

    protected PageObjectManager getPageObjectManager(WebDriver driver) {
        if (pageObjectManager == null) return new PageObjectManager(driver);
        return pageObjectManager;
    }

    protected String GetTableValues(String headerValue, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        return data.get(0).get(headerValue);
    }
}
