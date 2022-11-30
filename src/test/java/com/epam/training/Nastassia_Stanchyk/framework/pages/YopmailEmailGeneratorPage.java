package com.epam.training.Nastassia_Stanchyk.framework.pages;

import com.epam.training.Nastassia_Stanchyk.framework.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class YopmailEmailGeneratorPage extends AbstractBasePage {

    private static final String BASE_URL = "https://yopmail.com/ru/email-generator";

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
        log.info("Copy email address");
        return this;
    }

    public String getCopiedEmailAddress () {
        return StringUtils.copySelectedText();
    }

    public YopmailInboxPage checkInboxMail() {
        waitElementToBeClickable(checkInboxButton)
                .click();
        return new YopmailInboxPage(driver);
    }

    @Override
    public YopmailEmailGeneratorPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}
