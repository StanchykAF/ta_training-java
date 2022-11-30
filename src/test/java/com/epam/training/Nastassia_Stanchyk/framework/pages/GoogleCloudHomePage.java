package com.epam.training.Nastassia_Stanchyk.framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class GoogleCloudHomePage extends AbstractBasePage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Google Cloud home page is opened");
        return this;
    }

    public SearchResultPage searchForTerms(String term) {
        searchInput.clear();
        searchInput.sendKeys(term);
        searchInput.submit();
        log.info("Search for term [" + term + "] at Google Cloud page");
        return new SearchResultPage(driver, term);
    }
}
