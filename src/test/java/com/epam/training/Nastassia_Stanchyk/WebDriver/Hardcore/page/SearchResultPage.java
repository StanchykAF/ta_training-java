package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private String searchTerm;

    public SearchResultPage(WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
    }

    public GoogleCloudPricingCalculatorPage openGoogleCloudPricingCalculatorPage () {
        List<WebElement> searchResults = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.gs-title")));
        for (WebElement element : searchResults) {
            if (element.getText().equalsIgnoreCase(searchTerm)) {
                element.click();
                break;
            }
        }
        return new GoogleCloudPricingCalculatorPage(driver, searchTerm);
    }

}
