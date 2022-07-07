package com.epam.training.Nastassia_Stanchyk.WebDriver.BringItOn.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.BringItOn.model.PasteFormOptions;
import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy (css = "#postform-format + span")
    private WebElement syntaxHighlight;

    private final By pasteExpirationTimeDropdownList = By.cssSelector("#select2-postform-expiration-results > li");
    private final By syntaxHighlightDropdownSearch = By.cssSelector("span.select2-search.select2-search--dropdown > input");
    private final By syntaxHighlightSearchResults = By.cssSelector("#select2-postform-format-results > li[aria-label~='ALL'] > ul > li");

    public PastebinHomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage () {
        driver.get(HOMEPAGE_URL);
        closeCookiesWindow();
        return this;
    }

    public PastebinPasteResultPage createNewPaste (PasteFormOptions pasteFormOptions) {
        pasteFormText.sendKeys(pasteFormOptions.getPasteText());
        setSyntaxHighlight(pasteFormOptions.getSyntaxHighlight());
        setPasteExpirationTime(pasteFormOptions.getPasteExpirationTime());
        pasteName.sendKeys(pasteFormOptions.getPasteTitle());
        createNewPasteButton.click();
        closeCookiesWindow();
        return new PastebinPasteResultPage(driver);
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
        throw new RuntimeException("Entered time value is incorrect");
    }

    private void setSyntaxHighlight (String syntax) {
        syntaxHighlight.click();
        WebElement syntaxInput = wait.until(ExpectedConditions.presenceOfElementLocated(syntaxHighlightDropdownSearch));
        syntaxInput.sendKeys(syntax);
        List<WebElement> syntaxList = wait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(syntaxHighlightSearchResults));
        for (WebElement element : syntaxList) {
            if (syntax.equalsIgnoreCase(element.getText())) {
                element.click();
                return;
            }
        }
        throw new RuntimeException("Entered language is missing in dropdown list");
    }
}
