package com.epam.training.Nastassia_Stanchyk.webdriver.task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopmailHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://yopmail.com/";

    private final By generateEmailButtonLocator = By.xpath("//div[@id='listeliens']/a[@href='email-generator']");

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopmailHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public YopmailEmailGeneratorPage generateEmailAddress() {
        waitPresenceOfElementLocated(generateEmailButtonLocator)
                .click();
        return new YopmailEmailGeneratorPage(driver);
    }
}
