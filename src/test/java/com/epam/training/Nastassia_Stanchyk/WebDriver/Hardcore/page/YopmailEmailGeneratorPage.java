package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailEmailGeneratorPage {

    private WebDriver driver;

    public YopmailEmailGeneratorPage (WebDriver driver) {
        this.driver = driver;
    }

    public YopmailEmailGeneratorPage copyEmailAddress () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("cprnd")))
                .click();
        return this;
    }

    public YopmailInboxPage checkInboxMail () {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.nw > button[onclick='egengo();']")))
                .click();
        return new YopmailInboxPage(driver);
    }

}
