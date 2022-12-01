package com.epam.training.Nastassia_Stanchyk.webdriver.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "http://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement pasteFormText;

    @FindBy (css = "#postform-expiration + span")
    private WebElement pasteExpirationTime;

    @FindBy (id = "postform-name")
    private WebElement pasteName;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    @FindBy (css = "#postform-format + span")
    private WebElement syntaxHighlight;

    private static final String PASTE_EXPIRATION_DROPDOWN_OPTION = "//ul[@id='select2-postform-expiration-results']" +
            "/li[contains(text(), '%s')]";
    private static final String SYNTAX_HIGHLIGHT_DROPDOWN_OPTION = "//ul[@id='select2-postform-format-results']/li/ul" +
            "/li[contains(text(), '%s')]";

    public PastebinHomePage (WebDriver driver) {
        super(driver);
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
        return new PastebinPasteResultPage(driver);
    }

    private void setPasteExpirationTime (String time) {
        pasteExpirationTime.click();
        waitPresenceOfElementLocated(By.xpath(String.format(PASTE_EXPIRATION_DROPDOWN_OPTION,
                        time)))
                .click();
    }

    private void setSyntaxHighlight (String syntax) {
        syntaxHighlight.click();
        waitPresenceOfElementLocated(By.xpath(String.format(SYNTAX_HIGHLIGHT_DROPDOWN_OPTION,
                        syntax)))
                .click();
    }
}
