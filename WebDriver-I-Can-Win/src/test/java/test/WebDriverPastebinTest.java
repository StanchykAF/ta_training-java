package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinHomePage;

public class WebDriverPastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup () {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteTest () {
        new PastebinHomePage(driver)
                .openPage()
                .createNewPaste("Hello from WebDriver","helloweb");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown () {
        driver.quit();
        driver = null;
    }
}