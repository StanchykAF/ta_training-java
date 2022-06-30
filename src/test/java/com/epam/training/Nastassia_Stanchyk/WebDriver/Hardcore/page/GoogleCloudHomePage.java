package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudHomePage openPage () {
        driver.get(HOMEPAGE_URL);
        searchInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        return this;
    }

    public SearchResultPage searchForTerms (String term) {
        searchInput.click();
        searchInput.sendKeys(term);
        searchInput.submit();
        return new SearchResultPage (driver, term);
    }
}
