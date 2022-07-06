package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected By acceptButton = By.cssSelector("button[mode='primary']");

    protected AbstractPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void closeCookiesWindow () {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(acceptButton))
                .click();
    }
}
