package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page;

import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.model.PasteFormOptions;
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
    private final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(id = "postform-text")
    private WebElement pasteFormText;

    @FindBy(css = "#postform-expiration + span")
    private WebElement pasteExpirationTime;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    private final static String PASTE_EXPIRATION_DROPDOWN_OPTION = "//ul[@id='select2-postform-expiration-results']" +
            "/li[contains(text(), '%s')]";

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        closeCookiesWindow();
        return this;
    }

    private void setPasteExpirationTime(String time) {
        pasteExpirationTime.click();
        WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(PASTE_EXPIRATION_DROPDOWN_OPTION,
                        time))))
                .click();
    }
}
