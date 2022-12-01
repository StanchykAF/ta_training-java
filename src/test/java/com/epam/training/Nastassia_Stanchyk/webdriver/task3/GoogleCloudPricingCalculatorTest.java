package com.epam.training.Nastassia_Stanchyk.webdriver.task3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;
    private List<String> actualPricingResultsForm;
    private String actualTotalMonthlyPrice;

    @BeforeTest()
    private void browserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest(description = "Getting full calculated form")
    private void createCalculatedForm() {
        String searchTerm = "Google Cloud Platform Pricing Calculator";
        GoogleCloudPricingCalculatorPage actualPricingResults;
        FormData formData = new FormData();
        formData.setProductName("Compute Engine");
        formData.setNumberOfInstances("4");
        formData.setOperationSystem("Free");
        formData.setVMClass("Regular");
        formData.setInstanceSeries("N1");
        formData.setInstanceType("n1-standard-8");
        formData.setNumberOfGPUs("1");
        formData.setGPUType("NVIDIA Tesla V100");
        formData.setLocalSSD("2x375 GB");
        formData.setDatacenterLocation("Frankfurt");
        formData.setCommittedUsage("1 Year");
        actualPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPricingCalculatorPage()
                .calculatePrice(formData);
        actualPricingResultsForm = actualPricingResults.getCalculatedForm();
        actualTotalMonthlyPrice = actualPricingResults.getTotalMonthlyPrice();
    }

    @Test(description = "Checking VM class")
    public void checkVMClassTest() {
        Assert.assertTrue(
                searchInCalculatedForm("Provisioning model").contains("Regular"),
                "Issue in VM Class field: actual result is \n" + searchInCalculatedForm("Provisioning model")
        );
    }

    @Test(description = "Checking instance type")
    public void checkInstanceTypeTest() {
        Assert.assertTrue(
                searchInCalculatedForm("Instance type").contains("n1-standard-8"),
                "Issue in Instance Type field: actual result is \n" + searchInCalculatedForm("Instance type")
        );
    }

    @Test(description = "Checking local SSD")
    public void checkLocalSSDTest() {
        Assert.assertTrue(
                searchInCalculatedForm("Local SSD").contains("2x375 GiB"),
                "Issue in Local SSD field: actual result is \n" + searchInCalculatedForm("Local SSD")
        );
    }

    @Test(description = "Checking datacenter location")
    public void checkDatacenterLocationTest() {
        Assert.assertTrue(
                searchInCalculatedForm("Region").contains("Frankfurt"),
                "Issue in Datacenter Location field: actual result is \n" + searchInCalculatedForm("Region")
        );
    }

    @Test(description = "Checking committed usage term")
    public void checkCommitmentTermTest() {
        Assert.assertTrue(
                searchInCalculatedForm("Commitment term").contains("1 Year"),
                "Issue in Commitment Term field: actual result is \n" + searchInCalculatedForm("Commitment term")
        );
    }

    @Test(description = "Checking total price per month")
    public void checkTotalPricePerMonthTest() {
        Assert.assertTrue(actualTotalMonthlyPrice.contains("USD 1,081.20"),
                "Issue in Total Estimated Cost: actual result is \n" + actualTotalMonthlyPrice);
    }

    private String searchInCalculatedForm(String targetString) {
        for (String string : actualPricingResultsForm) {
            if (string.startsWith(targetString)) {
                return string;
            }
        }
        return "Not found";
    }

    @AfterTest(alwaysRun = true)
    private void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
