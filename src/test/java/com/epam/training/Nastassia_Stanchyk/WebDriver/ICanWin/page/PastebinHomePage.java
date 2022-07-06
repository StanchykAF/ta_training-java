package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.model.PasteFormOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "http://pastebin.com";
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy (id = "postform-text")
    private WebElement pasteFormText;

    @FindBy (css = "#postform-expiration + span")
    private WebElement pasteExpirationTime;

    @FindBy (id = "postform-name")
    private WebElement pasteName;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    private final By pasteExpirationTimeDropdownList = By.cssSelector("#select2-postform-expiration-results > li");

    public PastebinHomePage (WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage () {
        driver.get(HOMEPAGE_URL);
        closeCookiesWindow();
        return this;
    }

    public PastebinHomePage createNewPaste (PasteFormOptions pasteFormOptions) {
        pasteFormText.sendKeys(pasteFormOptions.getPASTE_TEXT());
        setPasteExpirationTime(pasteFormOptions.getPASTE_EXPIRATION_TIME());
        pasteName.sendKeys(pasteFormOptions.getPASTE_TITLE());
        createNewPasteButton.click();
        closeCookiesWindow();
        return this;
    }

    private void setPasteExpirationTime (String time) {
        pasteExpirationTime.click();
        List<WebElement> pasteExpirationTimeList = wait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(pasteExpirationTimeDropdownList));
        for (WebElement element : pasteExpirationTimeList) {
            if (time.equalsIgnoreCase(element.getText())) {
                element.click();
                return;
            }
        }
        throw new RuntimeException("Chosen time is incorrect");
    }
}
