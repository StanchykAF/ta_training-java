package com.epam.training.Nastassia_Stanchyk.framework.test;

import com.epam.training.Nastassia_Stanchyk.framework.service.CreateCalculatedForm;
import com.epam.training.Nastassia_Stanchyk.framework.pages.GoogleCloudHomePage;
import com.epam.training.Nastassia_Stanchyk.framework.pages.GoogleCloudPricingCalculatorPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MainFormTests extends AbstractBaseTest {

    @Test(description = "Check VM Class, Instance Type, Local SSD, Location, Commitment Term, Total price")
    public void mainFormCompletingTest() {
        SoftAssert softAssert = new SoftAssert();

        GoogleCloudPricingCalculatorPage mainFormPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPricingCalculatorPage()
                .goToTheMainForm()
                .selectProduct(googleCloudMainForm.getProductName())
                .setNumberOfInstances(googleCloudMainForm.getNumberOfInstances())
                .selectOperatingSystem(googleCloudMainForm.getOperationSystem())
                .selectVMClass(googleCloudMainForm.getVMClass())
                .selectInstanceSeries(googleCloudMainForm.getInstanceSeries())
                .selectInstanceType(googleCloudMainForm.getInstanceType())
                .selectAddGPUsCheckBox()
                .selectGPUType(googleCloudMainForm.getGPUType())
                .selectNumberOfGPUs(googleCloudMainForm.getNumberOfGPUs())
                .selectLocalSSD(googleCloudMainForm.getLocalSSD())
                .selectDatacenterLocation(googleCloudMainForm.getDatacenterLocation())
                .selectCommittedUsageTime(googleCloudMainForm.getCommittedUsage())
                .clickAddToEstimateButton();;

        calculatedForm = CreateCalculatedForm.completeCalculatedForm(mainFormPricingResults.getCalculatedForm(),
                mainFormPricingResults.getTotalMonthlyPrice());

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
