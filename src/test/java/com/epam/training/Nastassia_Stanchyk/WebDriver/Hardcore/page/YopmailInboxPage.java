package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailInboxPage extends AbstractPage {

    private final By refreshButton = By.id("refresh");
    private final By mailFrame = By.id("ifmail");
    private final By totalMonthlyPrice = By.cssSelector("td[colspan='3'] + td > h3");

    public YopmailInboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YopmailInboxPage openPage() throws RuntimeException {
        throw new RuntimeException("You should authorised first");
    }

    public String checkTotalMonthlyPrice() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driverWait().until(ExpectedConditions.elementToBeClickable(refreshButton))
                .click();
        driver.switchTo().frame(driverWait()
                .until(ExpectedConditions.presenceOfElementLocated(mailFrame)));
        return driverWait().until(ExpectedConditions.presenceOfElementLocated(totalMonthlyPrice))
                .getText();
    }
}
