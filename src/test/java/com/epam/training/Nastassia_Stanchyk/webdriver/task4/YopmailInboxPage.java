package com.epam.training.Nastassia_Stanchyk.webdriver.task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopmailInboxPage extends AbstractPage{

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
        driver.navigate().refresh();
        switchToFrame(mailFrame);
        return waitPresenceOfElementLocated(totalMonthlyPrice).getText();
    }
}
