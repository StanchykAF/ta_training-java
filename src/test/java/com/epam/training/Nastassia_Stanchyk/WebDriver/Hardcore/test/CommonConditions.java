package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.driver.DriverSingletone;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.CalculatedForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.GoogleCloudMainForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.EmailEstimateForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.GoogleCloudHomePage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.YopmailEmailGeneratorPage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.YopmailHomePage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.GoogleCloudMainFormCompleting;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.CreateCalculatedForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service.EmailEstimateFormCompleting;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected CalculatedForm calculatedForm;
    protected EmailEstimateForm emailEstimateForm;
    protected GoogleCloudMainForm googleCloudMainForm = GoogleCloudMainFormCompleting.completeForm();
    protected String searchTerm = "Google Cloud Platform Pricing Calculator";

    protected final Logger logger = LogManager.getRootLogger();

    @BeforeMethod()
    public void browserSetup() {
        driver = DriverSingletone.getDriver();
    }

    protected GoogleCloudPricingCalculatorPage getCalculatedMainFormInfo() {
        GoogleCloudPricingCalculatorPage mainFormPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPricingCalculatorPage()
                .addToEstimateMainForm(googleCloudMainForm);
        calculatedForm = CreateCalculatedForm.completeCalculatedForm(mainFormPricingResults.getCalculatedForm(),
                mainFormPricingResults.getTotalMonthlyPrice());
        return mainFormPricingResults;
    }

    protected YopmailEmailGeneratorPage getEmailAddress() {
        YopmailEmailGeneratorPage actualEmailResult = new YopmailHomePage(driver)
                .openPage()
                .generateEmailAddress()
                .copyEmailAddress();
        emailEstimateForm = EmailEstimateFormCompleting.completeEmailEstimateForm(actualEmailResult.getCopiedEmailAddress());
        logger.info("Copied Email: " + emailEstimateForm.getEmailAddress());
        return actualEmailResult;
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        logger.info("Closing browser");
        DriverSingletone.closeDriver();
    }
}
