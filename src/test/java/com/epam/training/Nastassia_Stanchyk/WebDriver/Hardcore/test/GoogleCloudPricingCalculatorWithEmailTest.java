package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleCloudPricingCalculatorWithEmailTest {

    private WebDriver driver;
    private List<WebElement> actualFormResults;
    private String totalMonthlyPriceFromEmail;
    private String totalMonthlyPriceFromForm;

    @BeforeTest(alwaysRun = true)
    private void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest (alwaysRun = true)
    private void googleCloudPlatformPricingCalculator () {
        String searchTerm = "Google Cloud Platform Pricing Calculator";
        GoogleCloudPricingCalculatorPage actualPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPricingCalculatorPage()
                .calculatePrice();
        actualFormResults = actualPricingResults.getCalculatedForm();
        totalMonthlyPriceFromForm = searchInList("Estimated Component Cost");
        String calculatorWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        YopmailEmailGeneratorPage actualEmailResult = new YopmailHomePage(driver)
                .openPage()
                .generateEmailAddress()
                .copyEmailAddress();
        String emailPageWindow = driver.getWindowHandle();
        driver.switchTo().window(calculatorWindow);
        actualPricingResults = actualPricingResults
                .pressTheEMAILButton()
                .sendEstimatedFormToEmail();
        driver.switchTo().window(emailPageWindow);
        totalMonthlyPriceFromEmail = actualEmailResult
                .checkInboxMail()
                .checkTotalMonthlyPrice();
    }

    @Test
    public void checkTotalPricePerMonthTest () {
        Assert.assertTrue(
                totalMonthlyPriceFromForm.contains(totalMonthlyPriceFromEmail),
                "Issue in Total Estimated Cost: actual result is \n" + totalMonthlyPriceFromForm
        );
    }

    private String searchInList (String targetString) {
        for (WebElement element : actualFormResults) {
            if (element.getText().startsWith(targetString)) {
                return element.getText();
            }
        }
        return "Not found";
    }

    @AfterTest(alwaysRun = true)
    private void browserTearDown () {
        driver.quit();
        driver = null;
    }

}
