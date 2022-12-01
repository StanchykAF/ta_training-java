package com.epam.training.Nastassia_Stanchyk.webdriver.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage searchForTerms(String term) {
        searchInput.clear();
        searchInput.sendKeys(term);
        searchInput.submit();
        return new SearchResultPage(driver, term);
    }
}
