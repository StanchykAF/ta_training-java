package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailEmailGeneratorPage extends AbstractPage {

    private final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    private final By copyButton = By.id("cprnd");
    private final By checkInboxButton = By.xpath("//button/span[text()='Проверить почту']");

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopmailEmailGeneratorPage copyEmailAddress() {
        WAIT.until(ExpectedConditions.elementToBeClickable(copyButton))
                .click();
        return this;
    }

    public YopmailInboxPage checkInboxMail() {
        WAIT.until(ExpectedConditions.elementToBeClickable(checkInboxButton))
                .click();
        return new YopmailInboxPage(driver);
    }

}
