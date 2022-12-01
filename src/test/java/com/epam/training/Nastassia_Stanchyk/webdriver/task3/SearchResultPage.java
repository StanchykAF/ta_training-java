package com.epam.training.Nastassia_Stanchyk.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends AbstractPage{

    private final String searchTerm;
    private final By searchResultsLocator = By.xpath("//div[@class = 'gs-title']/a[@class = 'gs-title']");

    public SearchResultPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public GoogleCloudPricingCalculatorPage openGoogleCloudPricingCalculatorPage() {
        List<WebElement> searchResults = waitPresenceOfAllElementsLocatedBy(searchResultsLocator);
        for (WebElement element : searchResults) {
            if (element.getText().equalsIgnoreCase(searchTerm)) {
                element.click();
                break;
            }
        }
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
