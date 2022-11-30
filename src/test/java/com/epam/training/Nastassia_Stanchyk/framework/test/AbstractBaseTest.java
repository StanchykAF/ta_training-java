package com.epam.training.Nastassia_Stanchyk.framework.test;

import com.epam.training.Nastassia_Stanchyk.framework.driver.DriverSingletone;
import com.epam.training.Nastassia_Stanchyk.framework.models.CalculatedForm;
import com.epam.training.Nastassia_Stanchyk.framework.models.EmailEstimateForm;
import com.epam.training.Nastassia_Stanchyk.framework.models.GoogleCloudMainForm;
import com.epam.training.Nastassia_Stanchyk.framework.service.GoogleCloudMainFormCompleting;
import com.epam.training.Nastassia_Stanchyk.framework.util.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners({TestListener.class})
public class AbstractBaseTest {

    protected WebDriver driver;
    protected CalculatedForm calculatedForm;
    protected EmailEstimateForm emailEstimateForm;
    protected GoogleCloudMainForm googleCloudMainForm = GoogleCloudMainFormCompleting.completeForm();
    protected String searchTerm = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod()
    public void browserSetup() {
        driver = DriverSingletone.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        log.info("Closing browser");
        DriverSingletone.closeDriver();
    }
}
