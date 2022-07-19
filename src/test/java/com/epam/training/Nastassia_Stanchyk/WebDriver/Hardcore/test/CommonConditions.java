package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.driver.DriverSingletone;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.CalculatedForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.ComputeEngineInstancesForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.EmailEstimateForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.GoogleCloudHomePage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.YopmailEmailGeneratorPage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.YopmailHomePage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.ComputeEngineInstancesFormCompleting;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.CreateCalculatedForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.EmailEstimateFormCompleting;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected String totalMonthlyPriceFromEmail;
    protected CalculatedForm calculatedForm;
    protected EmailEstimateForm emailEstimateForm;

    @BeforeTest()
    public void browserSetup() {
        driver = DriverSingletone.getDriver();
    }

    public void createCalculatedForm() {
        String searchTerm = "Google Cloud Platform Pricing Calculator";
        String googleCloudCalculatorWindow;
        String YopmailPageWindow;
        ComputeEngineInstancesForm computeEngineInstancesForm = ComputeEngineInstancesFormCompleting.completeForm();
        GoogleCloudPricingCalculatorPage actualPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPricingCalculatorPage()
                .calculatePrice(computeEngineInstancesForm);

        calculatedForm = CreateCalculatedForm.completeCalculatedForm(actualPricingResults.getCalculatedForm(),
                actualPricingResults.getTotalMonthlyPrice());

        googleCloudCalculatorWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        YopmailEmailGeneratorPage actualEmailResult = new YopmailHomePage(driver)
                .openPage()
                .generateEmailAddress()
                .copyEmailAddress();
        emailEstimateForm = EmailEstimateFormCompleting.completeEmailEstimateForm(actualEmailResult.getCopiedEmailAddress());
        YopmailPageWindow = driver.getWindowHandle();
        driver.switchTo().window(googleCloudCalculatorWindow);
        actualPricingResults
                .pressTheEMAILButton()
                .sendEstimatedFormToEmail(emailEstimateForm.getEmailAddress());
        driver.switchTo().window(YopmailPageWindow);
        totalMonthlyPriceFromEmail = actualEmailResult
                .checkInboxMail()
                .checkTotalMonthlyPrice();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        DriverSingletone.closeDriver();
    }
}
