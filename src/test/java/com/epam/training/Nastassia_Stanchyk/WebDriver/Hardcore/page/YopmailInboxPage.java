package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailInboxPage extends AbstractPage {

    private final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    private final By refreshButton = By.id("refresh");
    private final By mailFrame = By.id("ifmail");
    private final By totalMonthlyPrice = By.cssSelector("td[colspan='3'] + td > h3");

    public YopmailInboxPage(WebDriver driver) {
        super(driver);
    }

    public String checkTotalMonthlyPrice() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WAIT.until(ExpectedConditions.elementToBeClickable(refreshButton))
                .click();
        driver.switchTo().frame(WAIT
                .until(ExpectedConditions.presenceOfElementLocated(mailFrame)));
        return WAIT.until(ExpectedConditions.presenceOfElementLocated(totalMonthlyPrice))
                .getText();
    }
}
