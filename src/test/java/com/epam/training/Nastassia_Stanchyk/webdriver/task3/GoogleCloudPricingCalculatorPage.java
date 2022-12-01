package com.epam.training.Nastassia_Stanchyk.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage{

    private static final String DEFAULT_DROPDOWN_OPTION_XPATH = "//div[contains(@class, 'md-active')]" +
            "//md-option/div[contains(text(), '%s')]";
    private static final String PRODUCT_NAME_XPATH = "//div[contains(@title, '%s')]";

    private final By mainFrame = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private final By innerFrame = By.id("myFrame");
    private final By GPUTypeDropdown = By.xpath("//md-select[contains(@aria-label, 'GPU type')]");
    private final By resultBlock = By.xpath("//div[contains(@class, 'md-list-item-text')]");
    private final By totalMonthlyPrice = By.xpath("//*[@id='resultBlock']/md-card/md-card-content//div[@class='cpc-cart-total']/h2/b");

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

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage calculatePrice(FormData formData) {

        switchToFrame(mainFrame);
        switchToFrame(innerFrame);
        selectProduct(formData.getProductName());
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

    public GoogleCloudPricingCalculatorPage selectProduct (String productName) {
        waitPresenceOfElementLocated(By.xpath(String.format(PRODUCT_NAME_XPATH, productName)))
                .click();
        return this;
    }

    public List<String> getCalculatedForm() {
        List<String> calculatedFormText = new ArrayList<>();
        List<WebElement> calculatedForm = waitPresenceOfAllElementsLocatedBy(resultBlock);
        for (WebElement element : calculatedForm) {
            calculatedFormText.add(element.getText());
        }
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
}
