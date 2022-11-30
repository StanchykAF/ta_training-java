package com.epam.training.Nastassia_Stanchyk.framework.pages;

import com.epam.training.Nastassia_Stanchyk.framework.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SearchResultPage extends AbstractBasePage {

    private static final String BASE_URL = "https://cloud.google.com/s/results?q=";
    private final String searchTerm;
    private final By searchResultsLocator = By.xpath("//div[@class = 'gs-title']/a[@class = 'gs-title']");

    public SearchResultPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public GoogleCloudPricingCalculatorPage openGoogleCloudPricingCalculatorPage() {
        waitPresenceOfAllElementsLocatedBy(searchResultsLocator)
                .stream().filter(link -> link.getText().equalsIgnoreCase(searchTerm))
                .findFirst()
                .orElseThrow()
                .click();
        log.info("Open Price Calculator");
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(BASE_URL.concat(StringUtils.createSearchStringForURL(searchTerm)));
        log.info("Open search result page with term [" + searchTerm + "] directly");
        return this;
    }
}
