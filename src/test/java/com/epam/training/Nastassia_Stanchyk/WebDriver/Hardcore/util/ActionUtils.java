package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {

    public static void selectDropdownOption(String dropdownOptionsXpath, String option, WebDriverWait driverWait) {
        WebElement dropdownOption =
                driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(dropdownOptionsXpath,
                        option))));
        dropdownOption.click();
        driverWait.until(ExpectedConditions.invisibilityOf(dropdownOption));
    }
}
