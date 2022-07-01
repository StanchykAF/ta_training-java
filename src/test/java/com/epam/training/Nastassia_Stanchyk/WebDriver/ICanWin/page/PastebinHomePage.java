package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "http://pastebin.com";

    @FindBy (id = "postform-text")
    private WebElement pasteForm;

    @FindBy (xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[2]/div/span")
    private WebElement pasteExpiration;

    @FindBy (id = "postform-name")
    private WebElement pasteName;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    public PastebinHomePage (WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage () {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    @Override
    public PastebinHomePage createNewPaste (String pasteText, String pasteTitle) {
        pasteForm.sendKeys(pasteText);

        pasteExpiration.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-postform-expiration-results\"]/li[3]")))
                .click();

        pasteName.sendKeys(pasteTitle);
        createNewPasteButton.click();
        return this;
    }
}
