package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page.PastebinHomePage;

public class WebDriverPastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteTest () {
        new PastebinHomePage(driver)
                .openPage()
                .acceptCookies()
                .createNewPaste("Hello from WebDriver","helloweb")
                .acceptCookies();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        driver = null;
    }
}
