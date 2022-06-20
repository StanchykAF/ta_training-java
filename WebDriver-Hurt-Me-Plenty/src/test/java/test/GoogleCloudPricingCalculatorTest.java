package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;
    private GoogleCloudPricingCalculatorPage actualPricingResults;

    @BeforeTest (alwaysRun = true)
    private void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest (alwaysRun = true)
    private void googleCloudPlatformPricingCalculator () {
        String searchPhrase = "Google Cloud Platform Pricing Calculator";
        actualPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .createSearch(searchPhrase)
                .openGoogleCloudPricingCalculatorPage()
                .calculatePrice();
    }

}
