package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page.PastebinHomePage;

public class WebDriverPastebinTest {

    private WebDriver driver;
    private final String PASTE_TEXT = "Hello from WebDriver";
    private final String PASTE_TITLE = "helloweb";
    private final String PASTE_EXPIRATION_TIME = "10 Minutes";

    @BeforeMethod()
    public void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Create new paste form")
    public void createNewPasteTest () {
        new PastebinHomePage(driver)
                .openPage()
                .createNewPaste(PASTE_TEXT,PASTE_TITLE, PASTE_EXPIRATION_TIME);
    }

    @AfterMethod()
    public void browserTearDown () {
        driver.quit();
        driver = null;
    }
}
