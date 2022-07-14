package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorWithEmailTest extends CommonConditions {

    @Test(description = "Check equals between total price from site and from email")
    public void checkTotalPricePerMonthTest() {
        Assert.assertTrue(
                totalMonthlyPriceFromForm.contains(totalMonthlyPriceFromEmail),
                "Issue in Total Estimated Cost: actual result is \n" + totalMonthlyPriceFromForm
        );
    }
}
