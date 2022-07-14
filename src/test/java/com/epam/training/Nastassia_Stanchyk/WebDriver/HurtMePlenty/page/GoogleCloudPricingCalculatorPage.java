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
    private static final String DEFAULT_DROPDOWN_OPTION_LOCATOR = "//div[contains(@class, 'md-active')]" +
            "//md-option/div[contains(text(), '%s')]";

    @FindBy(css = "div.compute[title='Compute Engine']")
    private WebElement productName;

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

    @FindBy(css = "md-select[aria-label^='GPU type']")
    private WebElement GPUTypeDropdown;

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

    private final By mainFrame = By.cssSelector("#cloud-site > devsite-iframe > iframe");
    private final By innerFrame = By.cssSelector("#myFrame");
    private final By resultBlock = By.cssSelector("div.md-list-item-text");
    private final By totalMonthlyPrice = By.cssSelector("#resultBlock > md-card > md-card-content > div > div > div > h2 > b");

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage calculatePrice(FormData formData) {

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

    public List<String> getCalculatedForm() {
        List<String> calculatedFormText = new ArrayList<>();
        List<WebElement> calculatedForm =
                WAIT.until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultBlock));
        for (WebElement element : calculatedForm) {
            calculatedFormText.add(element.getText());
        }
        return calculatedFormText;
    }

    public String getTotalMonthlyPrice() {
        return WAIT.until(ExpectedConditions.presenceOfElementLocated(totalMonthlyPrice)).getText();
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem(String operatingSystem) {
        operatingSystemDropdown.click();
        selectDropdownOption(operatingSystem);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectVMClass(String VMClass) {
        VMClassDropdown.click();
        selectDropdownOption(VMClass);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceSeries(String series) {
        instanceSeriesDropdown.click();
        selectDropdownOption(series);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceType(String instanceType) {
        instanceTypeDropdown.click();
        selectDropdownOption(instanceType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String GPUType) {
        GPUTypeDropdown.click();
        selectDropdownOption(GPUType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        selectDropdownOption(numberOfGPUs);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String localSSD) {
        localSSDDropdown.click();
        selectDropdownOption(localSSD);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdown.click();
        selectDropdownOption(datacenterLocation);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsageTime(String committedUsage) {
        committedUsageDropdown.click();
        selectDropdownOption(committedUsage);
        return this;
    }

    private void selectDropdownOption(String option) {
        WebElement dropdownOption =
                WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(DEFAULT_DROPDOWN_OPTION_LOCATOR,
                        option))));
        dropdownOption.click();
        WAIT.until(ExpectedConditions.invisibilityOf(dropdownOption));
    }
}
