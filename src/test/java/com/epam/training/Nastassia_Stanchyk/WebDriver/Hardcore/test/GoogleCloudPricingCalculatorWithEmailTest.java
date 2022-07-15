package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.CalculatedForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorWithEmailTest extends CommonConditions {

    @Test(description = "Check equals between total price from site and from email")
    public void checkTotalPricePerMonthTest() {
        createCalculatedForm();
        Assert.assertTrue(calculatedForm.getTotalEstimatedCostPerMonth().contains(totalMonthlyPriceFromEmail),
                "In Form: " + calculatedForm.getTotalEstimatedCostPerMonth() +
                "\nIn Email: " + totalMonthlyPriceFromEmail);
    }
}
