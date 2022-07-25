package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.YopmailEmailGeneratorPage;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailTotalCostTest extends CommonConditions {

    @Test(description = "Check equals between total price from site and from email")
    public void checkTotalPricePerMonthTest() {
        String googleCloudCalculatorWindow;
        String YopmailPageWindow;
        String totalMonthlyPriceFromEmail;

        GoogleCloudPricingCalculatorPage actualPricingResults = getCalculatedMainFormInfo();
        googleCloudCalculatorWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        YopmailEmailGeneratorPage actualEmailResult = getEmailAddress();
        YopmailPageWindow = driver.getWindowHandle();
        driver.switchTo().window(googleCloudCalculatorWindow);
        actualPricingResults
                .clickTheEMAILButton()
                .sendEstimatedFormToEmail(emailEstimateForm.getEmailAddress());
        driver.switchTo().window(YopmailPageWindow);
        totalMonthlyPriceFromEmail = actualEmailResult
                .checkInboxMail()
                .getTotalMonthlyPrice();

        Assert.assertTrue(calculatedForm.getTotalEstimatedCostPerMonth().contains(totalMonthlyPriceFromEmail),
                "In Form: " + calculatedForm.getTotalEstimatedCostPerMonth() +
                        "\nIn Email: " + totalMonthlyPriceFromEmail);
    }
}
