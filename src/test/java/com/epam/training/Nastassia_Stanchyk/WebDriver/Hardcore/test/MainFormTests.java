package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MainFormTests extends CommonConditions {

    @Test(description = "Check VM Class, Instance Type, Local SSD, Location, Commitment Term, Total price")
    public void mainFormCompletingTest() {
        SoftAssert softAssert = new SoftAssert();
        getCalculatedMainFormInfo();
        softAssert.assertTrue(calculatedForm.getProvisioningModel().contains(googleCloudMainForm.getVMClass()),
                "VM Class:\nactual: " + calculatedForm.getProvisioningModel() +
                        "\nexpected: " + googleCloudMainForm.getVMClass());
        softAssert.assertTrue(calculatedForm.getInstanceType().contains(googleCloudMainForm.getInstanceType()),
                "Instance Type:\nactual: " + calculatedForm.getInstanceType() +
                        "\nexpected: " + googleCloudMainForm.getInstanceType());
        softAssert.assertTrue(calculatedForm.getLocalSSD().contains(googleCloudMainForm.getLocalSSD()),
                "Local SSD:\nactual: " + calculatedForm.getLocalSSD() +
                        "\nexpected: " + googleCloudMainForm.getLocalSSD());
        softAssert.assertTrue(calculatedForm.getRegion().contains(googleCloudMainForm.getDatacenterLocation()),
                "Datacenter Location:\nactual: " + calculatedForm.getRegion() +
                        "\nexpected: " + googleCloudMainForm.getDatacenterLocation());
        softAssert.assertTrue(calculatedForm.getCommitmentTerm().contains(googleCloudMainForm.getCommittedUsage()),
                "Commitment Term:\nactual: " + calculatedForm.getCommitmentTerm() +
                        "\nexpected: " + googleCloudMainForm.getCommittedUsage());
        softAssert.assertTrue(calculatedForm.getTotalEstimatedCostPerMonth().contains("USD 1,081.20"),
                "Total Estimated Cost:\nactual: " + calculatedForm.getTotalEstimatedCostPerMonth() +
                        "\nexpected: USD 1,081.20");
        softAssert.assertAll();
    }
}
