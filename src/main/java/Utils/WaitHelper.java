package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private WebDriver driver;
    WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout of 10 seconds
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
