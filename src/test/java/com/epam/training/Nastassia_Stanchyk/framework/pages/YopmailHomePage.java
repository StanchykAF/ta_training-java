package com.epam.training.Nastassia_Stanchyk.framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class YopmailHomePage extends AbstractBasePage {

    private static final String HOMEPAGE_URL = "https://yopmail.com/";

    private final By generateEmailButtonLocator = By.xpath("//div[@id='listeliens']/a[@href='email-generator']");

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YopmailHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Yopmail Home page opened");
        return this;
    }

    public YopmailEmailGeneratorPage generateEmailAddress() {
        waitPresenceOfElementLocated(generateEmailButtonLocator)
                .click();
        log.info("Generate email address");
        return new YopmailEmailGeneratorPage(driver);
    }
}
