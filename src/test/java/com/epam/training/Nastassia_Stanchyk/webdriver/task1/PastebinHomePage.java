package com.epam.training.Nastassia_Stanchyk.webdriver.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "http://pastebin.com";
    private final static String PASTE_EXPIRATION_DROPDOWN_OPTION = "//ul[@id='select2-postform-expiration-results']" +
            "/li[contains(text(), '%s')]";

    @FindBy(id = "postform-text")
    private WebElement pasteFormText;

    @FindBy(css = "#postform-expiration + span")
    private WebElement pasteExpirationTime;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        closeCookiesWindow();
        return this;
    }

    public PastebinHomePage createNewPaste(PasteFormOptions pasteFormOptions) {
        pasteFormText.sendKeys(pasteFormOptions.getPasteText());
        setPasteExpirationTime(pasteFormOptions.getPasteExpirationTime());
        pasteName.sendKeys(pasteFormOptions.getPasteTitle());
        createNewPasteButton.click();
        return this;
    }

    private void setPasteExpirationTime(String time) {
        pasteExpirationTime.click();
        waitPresenceOfElementLocated(By.xpath(String.format(PASTE_EXPIRATION_DROPDOWN_OPTION, time)))
                .click();
    }
}
