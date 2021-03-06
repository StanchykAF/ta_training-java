package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    private static final String BASE_URL = "https://cloud.google.com/s/results?q=";
    private final Logger logger = LogManager.getRootLogger();
    private final String searchTerm;
    private final By searchResultsLocator = By.cssSelector("a.gs-title");

    public SearchResultPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public GoogleCloudPricingCalculatorPage openGoogleCloudPricingCalculatorPage() {
        List<WebElement> searchResults = driverWait()
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultsLocator));
        for (WebElement element : searchResults) {
            if (element.getText().equalsIgnoreCase(searchTerm)) {
                element.click();
                break;
            }
        }
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(BASE_URL.concat(StringUtils.createSearchStringForURL(searchTerm)));
        logger.info("Open search result page with term [" + searchTerm + "] directly");
        return this;
    }
}
