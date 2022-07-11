package com.epam.training.Nastassia_Stanchyk.WebDriver.HurtMePlenty.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.HurtMePlenty.model.FormData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import com.epam.training.Nastassia_Stanchyk.WebDriver.HurtMePlenty.page.*;

import java.util.List;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;
    private List<WebElement> actualPricingResults;

    @BeforeTest ()
    private void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest (description = "Getting full calculated form")
    private void createCalculatedForm () {
        String searchTerm = "Google Cloud Platform Pricing Calculator";
        FormData formData = new FormData();
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
                .calculatePrice(formData)
                .getCalculatedForm();
    }

    @Test (description = "Checking VM class")
    public void checkVMClassTest () {
        Assert.assertTrue(
                searchInList("Provisioning model").contains("Regular"),
                "Issue in VM Class field: actual result is \n" + searchInList("Provisioning model")
        );
    }

    @Test (description = "Checking instance type")
    public void checkInstanceTypeTest () {
        Assert.assertTrue(
                searchInList("Instance type").contains("n1-standard-8"),
                "Issue in Instance Type field: actual result is \n" + searchInList("Instance type")
        );
    }

    @Test (description = "Checking local SSD")
    public void checkLocalSSDTest () {
        Assert.assertTrue(
                searchInList("Local SSD").contains("2x375 GiB"),
                "Issue in Local SSD field: actual result is \n" + searchInList("Local SSD")
        );
    }

    @Test (description = "Checking datacenter location")
    public void checkDatacenterLocationTest () {
        Assert.assertTrue(
                searchInList("Region").contains("Frankfurt"),
                "Issue in Datacenter Location field: actual result is \n" + searchInList("Region")
        );
    }

    @Test (description = "Checking committed usage term")
    public void checkCommitmentTermTest () {
        Assert.assertTrue(
                searchInList("Commitment term").contains("1 Year"),
                "Issue in Commitment Term field: actual result is \n" + searchInList("Commitment term")
        );
    }

    @Test (description = "Checking total price per month")
    public void checkTotalPricePerMonthTest () {
        Assert.assertTrue(
                searchInList("Estimated Component Cost").contains("USD 1,081.20"),
                "Issue in Total Estimated Cost: actual result is \n" + searchInList("Estimated Component Cost")
        );
    }

    private String searchInList (String targetString) {
        for (WebElement element : actualPricingResults) {
            if (element.getText().startsWith(targetString)) {
                return element.getText();
            }
        }
        return "Not found";
    }

    @AfterTest(alwaysRun = true)
    private void browserTearDown () {
        driver.quit();
        driver = null;
    }

}
