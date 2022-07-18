package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.ComputeEngineInstancesForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.EmailEstimateForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.EmailEstimateFormCompleting;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util.ActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    public EmailEstimateForm emailEstimateForm;

    private static final String BASE_URL = "https://cloud.google.com/products/calculator";
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

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement sendEmailButton;

    private final By mainFrame = By.cssSelector("#cloud-site > devsite-iframe > iframe");
    private final By innerFrame = By.cssSelector("#myFrame");
    private final By resultBlock = By.cssSelector("div.md-list-item-text");
    private final By totalMonthlyPrice = By.cssSelector("#resultBlock > md-card > md-card-content > div > div > div > h2 > b");
    private final By emailButton = By.id("email_quote");
    private final By emailInput = By.cssSelector("form[name='emailForm'] input[type='email']");

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage calculatePrice(ComputeEngineInstancesForm computeEngineInstancesForm) {

        driver.switchTo().frame(driverWait()
                .until(ExpectedConditions.presenceOfElementLocated(mainFrame)));
        driver.switchTo().frame(driver.findElement(innerFrame));

        productName.click();
        numberOfInstancesInput.sendKeys(computeEngineInstancesForm.getNumberOfInstances());
        selectOperatingSystem(computeEngineInstancesForm.getOperationSystem());
        selectVMClass(computeEngineInstancesForm.getVMClass());
        selectInstanceSeries(computeEngineInstancesForm.getInstanceSeries());
        selectInstanceType(computeEngineInstancesForm.getInstanceType());
        addGPUsCheckBox.click();
        selectGPUType(computeEngineInstancesForm.getGPUType());
        selectNumberOfGPUs(computeEngineInstancesForm.getNumberOfGPUs());
        selectLocalSSD(computeEngineInstancesForm.getLocalSSD());
        selectDatacenterLocation(computeEngineInstancesForm.getDatacenterLocation());
        selectCommittedUsageTime(computeEngineInstancesForm.getCommittedUsage());
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage pressTheEMAILButton() {
        driver.switchTo().frame(driverWait()
                .until(ExpectedConditions.presenceOfElementLocated(mainFrame)));
        driver.switchTo().frame(driver.findElement(innerFrame));

        driver.findElement(emailButton).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEstimatedFormToEmail() {
        try {
            String copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            emailEstimateForm = EmailEstimateFormCompleting.completeEmailEstimateForm(copiedText);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        driverWait().until(ExpectedConditions.presenceOfElementLocated(emailInput))
                .sendKeys(emailEstimateForm.getEmailAddress());
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
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, operatingSystem, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectVMClass(String VMClass) {
        VMClassDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, VMClass, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceSeries(String series) {
        instanceSeriesDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, series, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceType(String instanceType) {
        instanceTypeDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, instanceType, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String GPUType) {
        GPUTypeDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, GPUType, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, numberOfGPUs, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String localSSD) {
        localSSDDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, localSSD, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, datacenterLocation, driverWait());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsageTime(String committedUsage) {
        committedUsageDropdown.click();
        ActionUtils.selectDropdownOption(DEFAULT_DROPDOWN_OPTION_LOCATOR, committedUsage, driverWait());
        return this;
    }

    @Override
    public GoogleCloudPricingCalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
