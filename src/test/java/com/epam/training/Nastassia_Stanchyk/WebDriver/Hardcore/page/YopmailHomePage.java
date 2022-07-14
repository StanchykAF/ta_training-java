package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://yopmail.com/";

    private final By generateEmailButtonLocator = By.cssSelector("#listeliens > a[href='email-generator']");

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YopmailHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public YopmailEmailGeneratorPage generateEmailAddress() {
        driverWait().until(ExpectedConditions.presenceOfElementLocated(generateEmailButtonLocator))
                .click();
        return new YopmailEmailGeneratorPage(driver);
    }

}
