package com.epam.training.Nastassia_Stanchyk.webdriver.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailGeneratorPage extends AbstractPage{

    @FindBy(id = "cprnd")
    private WebElement copyButton;

    @FindBy(xpath = "//button/span[text()='Check Inbox']")
    private WebElement checkInboxButton;

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopmailEmailGeneratorPage copyEmailAddress() {
        waitElementToBeClickable(copyButton)
                .click();
        return this;
    }

    public YopmailInboxPage checkInboxMail() {
        waitElementToBeClickable(checkInboxButton)
                .click();
        return new YopmailInboxPage(driver);
    }
}
