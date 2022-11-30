package com.epam.training.Nastassia_Stanchyk.framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class GoogleCloudPricingCalculatorPage extends AbstractBasePage {

    private static final String BASE_URL = "https://cloud.google.com/products/calculator";
    private static final String DEFAULT_DROPDOWN_OPTION_XPATH = "//div[contains(@class, 'md-active')]" +
            "//md-option/div[contains(text(), '%s')]";
    private static final String PRODUCT_NAME_XPATH = "//div[contains(@title, '%s')]";

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/div/md-input-container/input[@name='quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Operating System')]")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'VM Class')]")
    private WebElement VMClassDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Series')]")
    private WebElement instanceSeriesDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Instance type')]")
    private WebElement instanceTypeDropdown;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[contains(@class, 'md-container')]")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Number of GPUs')]")
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[contains(@aria-label, 'Local SSD')]")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[contains(@aria-label, 'Datacenter location')]")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[contains(@aria-label, 'Committed usage')]")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button")
    private WebElement addToEstimateButton;

    @FindBy(id = "Email Estimate")
    private WebElement emailButton;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    private final By mainFrame = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private final By innerFrame = By.id("myFrame");
    private final By GPUTypeDropdown = By.xpath("//md-select[contains(@aria-label, 'GPU type')]");
    private final By resultBlock = By.xpath("//div[contains(@class, 'md-list-item-text')]");
    private final By totalMonthlyPrice = By.xpath("//*[@id='resultBlock']/md-card/md-card-content//div[@class='cpc-cart-total']/h2/b");

    private final By emailInput = By.cssSelector("form[name='emailForm'] input[type='email']");

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage goToTheMainForm() {
        switchToFrame(mainFrame);
        switchToFrame(innerFrame);
        log.info("Switch to main form frame");
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
        waitPresenceOfElementLocated(By.xpath(String.format(PRODUCT_NAME_XPATH, productName)))
                .click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumberOfInstances (String numberOfInstances) {
        numberOfInstancesInput.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickTheEMAILButton() {
        goToTheMainForm();
        log.info("Click Send by Email button");
        emailButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEstimatedFormToEmail(String emailAddress) {
        waitPresenceOfElementLocated(emailInput)
                .sendKeys(emailAddress);
        sendEmailButton.click();
        return this;
    }

    public List<String> getCalculatedForm() {
        List<String> calculatedFormText = new ArrayList<>();
        waitPresenceOfAllElementsLocatedBy(resultBlock)
                .forEach(element -> calculatedFormText.add(element.getText()));
        return calculatedFormText;
    }

    public String getTotalMonthlyPrice() {
        return waitPresenceOfElementLocated(totalMonthlyPrice).getText();
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem(String operatingSystem) {
        operatingSystemDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, operatingSystem);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectVMClass(String VMClass) {
        VMClassDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, VMClass);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceSeries(String series) {
        instanceSeriesDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, series);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceType(String instanceType) {
        instanceTypeDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, instanceType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String GPUType) {
        waitPresenceOfElementLocated(GPUTypeDropdown).click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, GPUType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, numberOfGPUs);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String localSSD) {
        localSSDDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, localSSD);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, datacenterLocation);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsageTime(String committedUsage) {
        committedUsageDropdown.click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, committedUsage);
        return this;
    }

    @Override
    public GoogleCloudPricingCalculatorPage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
