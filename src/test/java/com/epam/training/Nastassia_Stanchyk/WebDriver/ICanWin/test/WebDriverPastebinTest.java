package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.test;

import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.model.PasteFormOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.page.PastebinHomePage;

public class WebDriverPastebinTest {

    private WebDriver driver;

    @BeforeMethod()
    public void browserSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Create new paste form")
    public void createNewPasteTest () {
        PasteFormOptions pasteFormOptions = new PasteFormOptions("Hello from WebDriver",
                "helloweb",
                "10 Minutes");
        new PastebinHomePage(driver)
                .openPage()
                .createNewPaste(pasteFormOptions);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown () {
        driver.quit();
        driver = null;
    }
}
