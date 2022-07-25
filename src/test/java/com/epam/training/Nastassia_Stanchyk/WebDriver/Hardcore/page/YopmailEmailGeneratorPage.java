package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class YopmailEmailGeneratorPage extends AbstractPage {

    private static final String BASE_URL = "https://yopmail.com/ru/email-generator";
    private final Logger logger = LogManager.getRootLogger();
    private final By copyButton = By.id("cprnd");
    private final By checkInboxButton = By.xpath("//button/span[text()='Проверить почту']");

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopmailEmailGeneratorPage copyEmailAddress() {
        driverWait().until(ExpectedConditions.elementToBeClickable(copyButton))
                .click();
        logger.info("Copy email address");
        return this;
    }

    public String getCopiedEmailAddress () {
        String copiedText = "";
        try {
            copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return copiedText;
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
