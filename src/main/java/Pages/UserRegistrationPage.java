package Pages;

import Utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRegistrationPage {

    private static final Logger log = LoggerFactory.getLogger(UserRegistrationPage.class);
    private WebDriver driver;
    private WaitHelper wait;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='First Name']//..//..//..//input")
    private WebElement firstNameElement;

    public void enterFirstName(String firstName){
        log.info("Entering first name as -> {}", firstName);
        wait.waitUntilElementIsVisible(firstNameElement);
        firstNameElement.sendKeys(firstName);
    }

    @FindBy(xpath = "//span[text()='Last Name']//..//..//..//input")
    private WebElement lastNameElement;

    public void enterLastName(String lastName){
        log.info("Entering first name as -> {}", lastName);
        wait.waitUntilElementIsVisible(lastNameElement);
        lastNameElement.sendKeys(lastName);
    }

    @FindBy(xpath = "//span[text()='Phone']//..//..//..//input")
    private WebElement phoneElement;

    public void enterPhoneName(String phone){
        log.info("Entering Phone as -> {}", phone);
        wait.waitUntilElementIsVisible(phoneElement);
        phoneElement.sendKeys(phone);
    }

    @FindBy(xpath = "//span[text()='Social Security ID']//..//..//..//input")
    private WebElement ssnElement;

    public void enterSSNValue(String ssn){
        log.info("Entering SSN as -> {}", ssn);
        wait.waitUntilElementIsVisible(ssnElement);
        ssnElement.sendKeys(ssn);
    }

    @FindBy(xpath = "//div[@role='combobox' and @aria-labelledby='blood-type-label']")
    private WebElement bloodTypeDropdownElement;

    public void enterBloodType(String bloodType){
        log.info("Entering Blood Type as -> {}", bloodType);
        wait.waitUntilElementIsVisible(bloodTypeDropdownElement);
        bloodTypeDropdownElement.click();

        WebElement dropDownElement = driver.findElement(By.xpath(String.format("//li[@data-value='%s']", bloodType)));
        wait.waitUntilElementIsVisible(dropDownElement);
        dropDownElement.click();
    }

    @FindBy(xpath = "//div[@role='combobox' and @aria-labelledby='sex-label']")
    private WebElement sexTypeDropdownElement;

    public void enterSexType(String sexType){
        log.info("Entering Sex Type as -> {}", sexType);
        wait.waitUntilElementIsVisible(sexTypeDropdownElement);
        sexTypeDropdownElement.click();

        WebElement dropDownElement = driver.findElement(By.xpath(String.format("//li[@data-value='%s']", sexType)));
        wait.waitUntilElementIsVisible(dropDownElement);
        dropDownElement.click();
    }

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    private WebElement dobElement;

    public void enterDOB(String dob){
        log.info("Entering DOB as -> {}", dob);
        wait.waitUntilElementIsVisible(dobElement);
        dobElement.click();
        dobElement.sendKeys(dob);
    }

    @FindBy(xpath = "//span[text()='Physician First Name']//..//..//..//input")
    private WebElement physicianFirstNameElement;

    public void enterPhysicianFirstName(String physicianFirstName){
        log.info("Entering Physician First name as -> {}", physicianFirstName);
        wait.waitUntilElementIsVisible(physicianFirstNameElement);
        physicianFirstNameElement.sendKeys(physicianFirstName);
    }

    @FindBy(xpath = "//span[text()='Physician Last Name']//..//..//..//input")
    private WebElement physicianLastNameElement;

    public void enterPhysicianLastName(String physicianLastName){
        log.info("Entering Physician Last name as -> {}", physicianLastName);
        wait.waitUntilElementIsVisible(physicianLastNameElement);
        physicianLastNameElement.sendKeys(physicianLastName);
    }

    @FindBy(xpath = "//div[@role='combobox' and @aria-labelledby='physician-title-label']")
    private WebElement physicianTitleDropdownElement;

    public void enterPhysicianTitle(String physicianTitle){
        log.info("Entering Physician Title as -> {}", physicianTitle);
        wait.waitUntilElementIsVisible(physicianTitleDropdownElement);
        physicianTitleDropdownElement.click();

        WebElement dropDownElement = driver.findElement(By.xpath(String.format("//li[@data-value='%s']", physicianTitle)));
        wait.waitUntilElementIsVisible(dropDownElement);
        dropDownElement.click();
    }


    @FindBy(xpath = "//span[text()='Care Site Name']//..//..//..//input")
    private WebElement careSiteNameElement;

    public void enterCareSiteName(String careSiteName){
        log.info("Entering Care Site name as -> {}", careSiteName);
        wait.waitUntilElementIsVisible(careSiteNameElement);
        careSiteNameElement.sendKeys(careSiteName);
    }

    @FindBy(xpath = "//span[text()='Care Site Address']//..//..//..//input")
    private WebElement careSiteAddressElement;

    public void enterCareSiteAddress(String careSiteAddress){
        log.info("Entering Care Site address as -> {}", careSiteAddress);
        wait.waitUntilElementIsVisible(careSiteAddressElement);
        careSiteAddressElement.sendKeys(careSiteAddress);
    }

    @FindBy(xpath = "//span[text()='Email']//..//..//..//input")
    private WebElement userEmailElement;

    public void enterUserEmail(String userEmail){
        log.info("Entering User Email as -> {}", userEmail);
        wait.waitUntilElementIsVisible(userEmailElement);
        userEmailElement.sendKeys(userEmail);
    }

    @FindBy(xpath = "//span[text()='Password']//..//..//..//input")
    private WebElement userPasswordElement;

    public void enterUserPassword(String userPassword){
        log.info("Entering User Password as -> {}", userPassword);
        wait.waitUntilElementIsVisible(userPasswordElement);
        userPasswordElement.sendKeys(userPassword);
    }

    @FindBy(xpath = "//div[contains(@class,'MuiBox-root')]//button[@type='submit' and text()='Register']")
    private WebElement registerButton;

    public void clickRegisterButton() {
        log.info("Clicking on Register Button");
        wait.waitUntilElementIsVisible(registerButton);
        registerButton.click();
        wait.waitForPageToLoad();
    }

}
