package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailEmailGeneratorPage extends AbstractPage {

    private static final String BASE_URL = "https://yopmail.com/ru/email-generator";
    private final By copyButton = By.id("cprnd");
    private final By checkInboxButton = By.xpath("//button/span[text()='Проверить почту']");

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopmailEmailGeneratorPage copyEmailAddress() {
        driverWait().until(ExpectedConditions.elementToBeClickable(copyButton))
                .click();
        return this;
    }

    public YopmailInboxPage checkInboxMail() {
        driverWait().until(ExpectedConditions.elementToBeClickable(checkInboxButton))
                .click();
        return new YopmailInboxPage(driver);
    }

    @Override
    public YopmailEmailGeneratorPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

}
