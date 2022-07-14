package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebElement searchInput;
    private final By searchField = By.name("q");

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage searchForTerms(String term) {
        searchInput = driverWait().until(ExpectedConditions.presenceOfElementLocated(searchField));
        searchInput.sendKeys(term);
        searchInput.submit();
        return new SearchResultPage(driver, term);
    }
}
