package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailHomePage {

    private static final String HOMEPAGE_URL = "https://yopmail.com/";
    private WebDriver driver;
    private WebElement generateButton;

    public YopmailHomePage (WebDriver driver) {
        this.driver = driver;
    }

    public YopmailHomePage openPage () {
        driver.get(HOMEPAGE_URL);
        generateButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#listeliens > a[href='email-generator']")));
        return this;
    }

    public YopmailEmailGeneratorPage generateEmailAddress() {
        generateButton.click();
        return new YopmailEmailGeneratorPage(driver);
    }

}
