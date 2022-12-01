package com.epam.training.Nastassia_Stanchyk.webdriver.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinPasteResultPage extends AbstractPage{

    private final By title = By.cssSelector(".info-top h1");
    private final By syntax = By.cssSelector("div.left > a");
    private final By sourceCode = By.cssSelector(".highlighted-code > div.source");

    public PastebinPasteResultPage (WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return waitPresenceOfElementLocated(title).getText();
    }

    public String getSyntaxHighlight() {
        return waitPresenceOfElementLocated(syntax).getText();
    }

    public String getText() {
        return waitPresenceOfElementLocated(sourceCode).getText();
    }
}
