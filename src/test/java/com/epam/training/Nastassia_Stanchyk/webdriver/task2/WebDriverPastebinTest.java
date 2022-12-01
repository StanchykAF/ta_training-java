package com.epam.training.Nastassia_Stanchyk.webdriver.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverPastebinTest {

    private WebDriver driver;
    private PastebinPasteResultPage actualPasteResults;
    private PasteFormOptions pasteFormOptions;

    @BeforeTest()
    private void browserSetup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest (description = "Create new paste form")
    private void createNewPaste () {
        String pasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String pasteTitle = "how to gain dominance among developers";
        String pasteExpirationTime = "10 Minutes";
        String syntaxHighlight = "Bash";
        pasteFormOptions = new PasteFormOptions(pasteText, pasteTitle, pasteExpirationTime, syntaxHighlight);
        actualPasteResults = new PastebinHomePage(driver)
                .openPage()
                .createNewPaste(pasteFormOptions);
    }

    @Test(description = "Check Title")
    public void pasteTitleTest () {
        Assert.assertEquals(actualPasteResults.getTitle(), pasteFormOptions.getPasteTitle(),
                "Text of title is incorrect");
    }

    @Test (description = "Check Code")
    public void pasteTextTest (){
        Assert.assertEquals(actualPasteResults.getText(), pasteFormOptions.getPasteText(),
                "Text of code is incorrect");
    }

    @Test (description = "Check Syntax")
    public void pasteSyntaxHighlight () {
        Assert.assertEquals(actualPasteResults.getSyntaxHighlight(), pasteFormOptions.getSyntaxHighlight(),
                "Syntax Highlight is incorrect");
    }

    @AfterTest(alwaysRun = true)
    private void browserTearDown () {
        driver.quit();
        driver = null;
    }
}
