package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.GoogleCloudMainForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util.ActionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private static final String BASE_URL = "https://cloud.google.com/products/calculator";
    private static final String DEFAULT_DROPDOWN_OPTION_XPATH = "//div[contains(@class, 'md-active')]" +
            "//md-option/div[contains(text(), '%s')]";
    private static final String PRODUCT_NAME_XPATH = "//div[contains(@title, '%s')]";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(css = "form[name='ComputeEngineForm'] > div > div > md-input-container > input[name='quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy(css = "md-select[aria-label^='Operating System']")
    private WebElement operatingSystemDropdown;

    @FindBy(css = "md-select[aria-label^='VM Class']")
    private WebElement VMClassDropdown;

    @FindBy(css = "md-select[aria-label^='Series']")
    private WebElement instanceSeriesDropdown;

    @FindBy(css = "md-select[aria-label^='Instance type']")
    private WebElement instanceTypeDropdown;

    @FindBy(css = "md-checkbox[ng-model='listingCtrl.computeServer.addGPUs'] > div.md-container.md-ink-ripple")
    private WebElement addGPUsCheckBox;

    @FindBy(css = "md-select[aria-label^='Number of GPUs']")
    private WebElement numberOfGPUsDropdown;

    @FindBy(css = "md-select[aria-label^='Local SSD']")
    private WebElement localSSDDropdown;

    @FindBy(css = "md-select[aria-label^='Datacenter location']")
    private WebElement datacenterLocationDropdown;

    @FindBy(css = "md-select[aria-label^='Committed usage']")
    private WebElement committedUsageDropdown;

    @FindBy(css = "form[name='ComputeEngineForm'] > div > button")
    private WebElement addToEstimateButton;

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement sendEmailButton;

    private final By mainFrame = By.cssSelector("#cloud-site > devsite-iframe > iframe");
    private final By innerFrame = By.cssSelector("#myFrame");
    private final By resultBlock = By.cssSelector("div.md-list-item-text");
    private final By totalMonthlyPrice = By.cssSelector("#resultBlock > md-card > md-card-content > div > div > div > h2 > b");
    private final By emailButton = By.id("email_quote");
    private final By emailInput = By.cssSelector("form[name='emailForm'] input[type='email']");
    private final By GPUTypeDropdown = By.cssSelector("md-select[aria-label^='GPU type']");

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage addToEstimateMainForm(GoogleCloudMainForm googleCloudMainForm) {
        switchToFrame(mainFrame)
                .switchToFrame(innerFrame)
                .selectProduct(googleCloudMainForm.getProductName())
                .setNumberOfInstances(googleCloudMainForm.getNumberOfInstances())
                .selectOperatingSystem(googleCloudMainForm.getOperationSystem())
                .selectVMClass(googleCloudMainForm.getVMClass())
                .selectInstanceSeries(googleCloudMainForm.getInstanceSeries())
                .selectInstanceType(googleCloudMainForm.getInstanceType())
                .selectAddGPUsCheckBox()
                .selectGPUType(googleCloudMainForm.getGPUType())
                .selectNumberOfGPUs(googleCloudMainForm.getNumberOfGPUs())
                .selectLocalSSD(googleCloudMainForm.getLocalSSD())
                .selectDatacenterLocation(googleCloudMainForm.getDatacenterLocation())
                .selectCommittedUsageTime(googleCloudMainForm.getCommittedUsage())
                .clickAddToEstimateButton();
        logger.info("Added to estimate");
        return this;
    }

    public GoogleCloudPricingCalculatorPage switchToFrame (By frame) {
        driver.switchTo().frame(driverWait()
                .until(ExpectedConditions.presenceOfElementLocated(frame)));
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton () {
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectAddGPUsCheckBox () {
        addGPUsCheckBox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectProduct (String productName) {
        driverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(PRODUCT_NAME_XPATH,
                productName))))
                .click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumberOfInstances (String numberOfInstances) {
        numberOfInstancesInput.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickTheEMAILButton() {
        switchToFrame(mainFrame)
                .switchToFrame(innerFrame);
        driver.findElement(emailButton).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEstimatedFormToEmail(String emailAddress) {
        driverWait().until(ExpectedConditions.presenceOfElementLocated(emailInput))
                .sendKeys(emailAddress);
        sendEmailButton.click();
        return this;
    }

    public List<String> getCalculatedForm() {
        List<String> calculatedFormText = new ArrayList<>();
        List<WebElement> calculatedForm =
                driverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultBlock));
        for (WebElement element : calculatedForm) {
            calculatedFormText.add(element.getText());
        }
        return calculatedFormText;
    }

    public String getTotalMonthlyPrice() {
        return driverWait().until(ExpectedConditions.presenceOfElementLocated(totalMonthlyPrice)).getText();
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem(String operatingSystem) {
        operatingSystemDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, operatingSystem, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectVMClass(String VMClass) {
        VMClassDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, VMClass, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceSeries(String series) {
        instanceSeriesDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, series, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceType(String instanceType) {
        instanceTypeDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, instanceType, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String GPUType) {
        driverWait().until(ExpectedConditions.presenceOfElementLocated(GPUTypeDropdown)).click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, GPUType, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, numberOfGPUs, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String localSSD) {
        localSSDDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, localSSD, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, datacenterLocation, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsageTime(String committedUsage) {
        committedUsageDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, committedUsage, driverWait());
        return this;
    }

    @Override
    public GoogleCloudPricingCalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
