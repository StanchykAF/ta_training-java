package com.epam.training.Nastassia_Stanchyk.WebDriver.HurtMePlenty.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.HurtMePlenty.model.FormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    private String defaultDropdownOptionLocator = "//div[contains(@class, 'md-active')]" +
        "//md-option/div[contains(text(), '%s')]";

    @FindBy (css = "div.compute[title='Compute Engine']")
    private WebElement productName;

    @FindBy (css = "form[name='ComputeEngineForm'] > div > div > md-input-container > input[name='quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy (css = "md-select[aria-label^='Operating System']")
    private WebElement operatingSystemDropdown;

    @FindBy (css = "md-select[aria-label^='VM Class']")
    private WebElement VMClassDropdown;

    @FindBy (css = "md-select[aria-label^='Series']")
    private WebElement instanceSeriesDropdown;

    @FindBy (css = "md-select[aria-label^='Instance type']")
    private WebElement instanceTypeDropdown;

    @FindBy (css = "md-checkbox[ng-model='listingCtrl.computeServer.addGPUs'] > div.md-container.md-ink-ripple")
    private WebElement addGPUsCheckBox;

    @FindBy (css = "md-select[aria-label^='GPU type']")
    private WebElement GPUTypeDropdown;

    @FindBy (css = "md-select[aria-label^='Number of GPUs']")
    private WebElement numberOfGPUsDropdown;

    @FindBy (css = "md-select[aria-label^='Local SSD']")
    private WebElement localSSDDropdown;

    @FindBy (css = "md-select[aria-label^='Datacenter location']")
    private WebElement datacenterLocationDropdown;

    @FindBy (css = "md-select[aria-label^='Committed usage']")
    private WebElement committedUsageDropdown;

    @FindBy (css = "form[name='ComputeEngineForm'] > div > button")
    private WebElement addToEstimateButton;

    private final By mainFrame = By.cssSelector("#cloud-site > devsite-iframe > iframe");
    private final By innerFrame = By.cssSelector("#myFrame");

    public GoogleCloudPricingCalculatorPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage calculatePrice (FormData formData) {

        driver.switchTo().frame(WAIT
                .until(ExpectedConditions.presenceOfElementLocated(mainFrame)));
        driver.switchTo().frame(driver.findElement(innerFrame));

        productName.click();
        numberOfInstancesInput.sendKeys(formData.getNumberOfInstances());
        selectOperatingSystem(formData.getOperationSystem());
        selectVMClass(formData.getVMClass());
        selectInstanceSeries(formData.getInstanceSeries());
        selectInstanceType(formData.getInstanceType());
        addGPUsCheckBox.click();
        selectGPUType(formData.getGPUType());
        selectNumberOfGPUs(formData.getNumberOfGPUs());
        selectLocalSSD(formData.getLocalSSD());
        selectDatacenterLocation(formData.getDatacenterLocation());
        selectCommittedUsageTime(formData.getCommittedUsage());
        addToEstimateButton.click();
        return this;
    }

    public List<String> getCalculatedForm () {
        List<String> calculatedFormText = new ArrayList<>();
        List<WebElement> calculatedForm =
                WAIT.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.md-list-item-text")));
        for (WebElement element : calculatedForm) {
            calculatedFormText.add(element.getText());
        }
        return calculatedFormText;
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem (String operatingSystem) {
        operatingSystemDropdown.click();
        selectDropdownOption(operatingSystem).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectVMClass (String VMClass) {
        VMClassDropdown.click();
        selectDropdownOption(VMClass).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceSeries (String series) {
        instanceSeriesDropdown.click();
        selectDropdownOption(series).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceType (String instanceType) {
        instanceTypeDropdown.click();
        selectDropdownOption(instanceType).click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage selectGPUType (String GPUType) {
        GPUTypeDropdown.click();
        WebElement option = selectDropdownOption(GPUType);
        option.click();
        WAIT.until(ExpectedConditions.invisibilityOf(option));
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs (String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        selectDropdownOption(numberOfGPUs).findElement(By.xpath("..")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD (String localSSD) {
        localSSDDropdown.click();
        selectDropdownOption(localSSD).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation (String datacenterLocation) {
        datacenterLocationDropdown.click();
        selectDropdownOption(datacenterLocation).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsageTime (String committedUsage) {
        committedUsageDropdown.click();
        selectDropdownOption(committedUsage).click();
        return this;
    }

    private WebElement selectDropdownOption (String option) {
        return WAIT.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(defaultDropdownOptionLocator,
                option))));
    }
}
