package Steps;

import Drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);  // Create a logger instance
    WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each scenario
        driver = DriverManager.getDriver();
        logger.info("Browser opened.");
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take screenshot if the scenario fails
        if (scenario.isFailed()) {
            logger.error("Scenario failed. Taking screenshot...");
            takeScreenshot(scenario);
        } else {
            logger.info("Scenario passed.");
        }

        // Quit the browser after each scenario
        DriverManager.quitDriver();
        logger.info("Browser closed.");
    }

    private void takeScreenshot(Scenario scenario) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on failure");

            // Save the screenshot to a file (optional)
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshotFile.toPath(), new File("screenshots/" + scenario.getName() + ".png").toPath());
                logger.info("Screenshot saved at: screenshots/" + scenario.getName() + ".png");
            } catch (IOException e) {
                logger.error("Failed to save screenshot: ", e);
            }
        }
    }
}
