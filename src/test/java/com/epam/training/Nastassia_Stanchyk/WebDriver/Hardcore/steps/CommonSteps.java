package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.steps;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.driver.DriverSingletone;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.GoogleCloudMainForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page.GoogleCloudPricingCalculatorPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonSteps {

    private final Logger logger = LogManager.getRootLogger();

    public void addToEstimateMainForm(GoogleCloudMainForm googleCloudMainForm) {
        new GoogleCloudPricingCalculatorPage(DriverSingletone.getDriver()).switchToMainFrame()
                .switchToInnerFrame()
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
                .clickAddToEstimateButton();
        logger.info("Added to estimate");
    }
}
