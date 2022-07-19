package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();
    private WebElement searchInput;
    private final By searchField = By.name("q");

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Google Cloud home page opened");
        return this;
    }

    public SearchResultPage searchForTerms(String term) {
        searchInput = driverWait().until(ExpectedConditions.presenceOfElementLocated(searchField));
        searchInput.sendKeys(term);
        searchInput.submit();
        logger.info("Search for term [" + term + "] at Google Cloud page");
        return new SearchResultPage(driver, term);
    }
}
