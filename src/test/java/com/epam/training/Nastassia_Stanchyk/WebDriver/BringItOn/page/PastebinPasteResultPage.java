package com.epam.training.Nastassia_Stanchyk.WebDriver.BringItOn.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPasteResultPage extends AbstractPage {

    private final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    private final By title = By.cssSelector(".info-top h1");
    private final By syntax = By.cssSelector("div.left > a");
    private final By sourceCode = By.cssSelector(".highlighted-code > div.source");

    public PastebinPasteResultPage (WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return WAIT.until(ExpectedConditions.presenceOfElementLocated(title))
                .getText();
    }

    public String getSyntaxHighlight() {
        return WAIT.until(ExpectedConditions.presenceOfElementLocated(syntax))
                .getText();
    }

    public String getText() {
        return WAIT.until(ExpectedConditions.presenceOfElementLocated(sourceCode))
                .getText();
    }
}
