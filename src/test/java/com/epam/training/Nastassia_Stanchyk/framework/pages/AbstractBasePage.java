package com.epam.training.Nastassia_Stanchyk.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 20;

    protected abstract AbstractBasePage openPage();

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected AbstractBasePage switchToFrame (By frame) {
        driver.switchTo().frame(waitPresenceOfElementLocated(frame));
        return this;
    }

    protected WebDriverWait getNewWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    protected void waitPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        while (!js.executeScript("return document.readyState").equals("complete")) {}
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> waitPresenceOfAllElementsLocatedBy(By locator) {
        return getNewWait()
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected WebElement waitPresenceOfElementLocated(By locator) {
        return getNewWait()
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitInvisibilityOf(WebElement element) {
        getNewWait().until(ExpectedConditions.invisibilityOf(element));
    }

    protected WebElement waitElementToBeClickable(WebElement element) {
        return getNewWait()
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void selectDropdownOption(String dropdownOptionsXpath, String option) {
        WebElement dropdownOption =
                waitPresenceOfElementLocated(By.xpath(String.format(dropdownOptionsXpath, option)));
        dropdownOption.click();
        waitInvisibilityOf(dropdownOption);
    }
}
