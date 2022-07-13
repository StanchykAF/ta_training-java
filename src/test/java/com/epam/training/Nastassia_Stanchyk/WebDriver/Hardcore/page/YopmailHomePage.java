package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://yopmail.com/";
    private WebElement generateButton;

    private final By generateEmailButtonLocator = By.cssSelector("#listeliens > a[href='email-generator']");

    public YopmailHomePage (WebDriver driver) {
        super(driver);
    }

    public YopmailHomePage openPage () {
        driver.get(HOMEPAGE_URL);
        generateButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(generateEmailButtonLocator));
        return this;
    }

    public YopmailEmailGeneratorPage generateEmailAddress() {
        generateButton.click();
        return new YopmailEmailGeneratorPage(driver);
    }

}
