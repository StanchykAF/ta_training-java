package com.epam.training.Nastassia_Stanchyk.framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class YopmailInboxPage extends AbstractBasePage {

    private final By mailFrame = By.id("ifmail");
    private final By totalMonthlyPrice = By.cssSelector("td[colspan='3'] + td > h3");

    public YopmailInboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YopmailInboxPage openPage() throws RuntimeException {
        throw new RuntimeException("You should authorised first");
    }

    public String getTotalMonthlyPrice() {
        while (findElements(totalMonthlyPrice).size() == 0) {
            log.info("Refreshing page");
            driver.navigate().refresh();
            switchToFrame(mailFrame);
            waitPageLoad();
        }
        log.info("Getting Total Price from email");
        return findElement(totalMonthlyPrice).getText();
    }
}
