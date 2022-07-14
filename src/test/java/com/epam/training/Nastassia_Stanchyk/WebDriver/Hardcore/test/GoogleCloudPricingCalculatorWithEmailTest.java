package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.*;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.FormData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorWithEmailTest {

    private WebDriver driver;
    private String totalMonthlyPriceFromEmail;
    private String totalMonthlyPriceFromForm;

    @BeforeTest()
    private void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest ()
    private void googleCloudPlatformPricingCalculator () {
        String searchTerm = "Google Cloud Platform Pricing Calculator";
        String googleCloudCalculatorWindow;
        String YopmailPageWindow;
        FormData formData = new FormData();
        formData.setNumberOfInstances("4");
        formData.setOperationSystem("Free");
        formData.setVMClass("Regular");
        formData.setInstanceSeries("N1");
        formData.setInstanceType("n1-standard-8");
        formData.setNumberOfGPUs("1");
        formData.setGPUType("NVIDIA Tesla V100");
        formData.setLocalSSD("2x375 GB");
        formData.setDatacenterLocation("Frankfurt");
        formData.setCommittedUsage("1 Year");
        GoogleCloudPricingCalculatorPage actualPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPricingCalculatorPage()
                .calculatePrice(formData);
        totalMonthlyPriceFromForm = actualPricingResults.getTotalMonthlyPrice();
        googleCloudCalculatorWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        YopmailEmailGeneratorPage actualEmailResult = new YopmailHomePage(driver)
                .openPage()
                .generateEmailAddress()
                .copyEmailAddress();
        YopmailPageWindow = driver.getWindowHandle();
        driver.switchTo().window(googleCloudCalculatorWindow);
        actualPricingResults
                .pressTheEMAILButton()
                .sendEstimatedFormToEmail();
        driver.switchTo().window(YopmailPageWindow);
        totalMonthlyPriceFromEmail = actualEmailResult
                .checkInboxMail()
                .checkTotalMonthlyPrice();
    }

    @Test(description = "Check equals between total price from site and from email")
    public void checkTotalPricePerMonthTest () {
        Assert.assertTrue(
                totalMonthlyPriceFromForm.contains(totalMonthlyPriceFromEmail),
                "Issue in Total Estimated Cost: actual result is \n" + totalMonthlyPriceFromForm
        );
    }

    @AfterTest(alwaysRun = true)
    private void browserTearDown () {
        driver.quit();
        driver = null;
    }

}
