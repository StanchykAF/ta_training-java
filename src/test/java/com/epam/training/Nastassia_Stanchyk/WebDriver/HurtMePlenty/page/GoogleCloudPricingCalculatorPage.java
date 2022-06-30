package com.epam.training.Nastassia_Stanchyk.WebDriver.HurtMePlenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudPricingCalculatorPage {

    private WebDriver driver;
    private String searchTerm;

    @FindBy (css = "div.compute[title='Compute Engine']")
    private WebElement productName;

    @FindBy (css = "#input_85")
    private WebElement numberOfInstances;

    @FindBy (css = "md-checkbox[ng-model='listingCtrl.computeServer.addGPUs'] > div.md-container.md-ink-ripple")
    private WebElement addGPUsCheckBox;

    @FindBy (css = "div.compute-engine-block form[name='ComputeEngineForm'] > div > button")
    private WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorPage (WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage calculatePrice () {

        driver.switchTo().frame(new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cloud-site > devsite-iframe > iframe"))));
        driver.switchTo().frame(driver.findElement(By.cssSelector("#myFrame")));

        productName.click();
        numberOfInstances.sendKeys("4");

        dropdownsProcessing("#select_98", "#select_option_87");
        dropdownsProcessing("#select_102", "#select_option_100");
        dropdownsProcessing("#select_110", "md-option[value='n1']");
        dropdownsProcessing("#select_112", "md-option[value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");

        addGPUsCheckBox.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("md-select[placeholder='GPU type']")))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("md-option[value='NVIDIA_TESLA_V100']")))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("md-select[placeholder='Number of GPUs']")))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_container_459 md-option[value='1']")))
                .click();

        dropdownsProcessing("#select_413", "#select_container_414 md-option[value='2']");
        dropdownsProcessing("#select_118", "#select_container_119 md-option[value='europe-west3']");
        dropdownsProcessing("#select_125", "#select_container_126 md-option[value='1']");
        addToEstimateButton.click();
        return this;
    }

    public List<WebElement> getCalculatedForm () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.md-list-item-text")));
    }

    private void dropdownsProcessing (String dropdownSelector, String dropdownOptionSelector) {
        driver.findElement(By.cssSelector(dropdownSelector)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(dropdownOptionSelector)))
                .click();
    }
}
