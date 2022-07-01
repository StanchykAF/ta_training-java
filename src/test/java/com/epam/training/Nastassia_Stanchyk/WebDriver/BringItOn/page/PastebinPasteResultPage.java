package com.epam.training.Nastassia_Stanchyk.WebDriver.BringItOn.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPasteResultPage extends AbstractPage {

    public PastebinPasteResultPage (WebDriver driver) {
        super(driver);
    }

    public String checkTitle () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".info-top h1")))
                .getText();
    }

    public String checkSyntaxHighlight () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']/a[@class='btn -small h_800']")))
                .getText();
    }

    public String checkText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"highlighted-code\"]/div[@class=\"source\"]")))
                .getText();
    }

    @Override
    public AbstractPage createNewPaste (String pasteText, String pasteTitle) {
        throw new RuntimeException("This is paste result page. You cannot create new paste from here.");
    }
}
