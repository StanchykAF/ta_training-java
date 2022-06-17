package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.PastebinHomePage;
import page.PastebinPasteResultPage;


public class WebDriverPastebinTest {

    private WebDriver driver;
    private PastebinPasteResultPage actualPasteResults;
    private String pasteText;
    private String pasteTitle;

    @BeforeTest (alwaysRun = true)
    private void browserSetup () {
//        driver = new SafariDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest (alwaysRun = true)
    private void createNewPaste () {
        pasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        pasteTitle = "how to gain dominance among developers";
        actualPasteResults = new PastebinHomePage(driver)
                .openPage()
                .createNewPaste(pasteText, pasteTitle);
    }

    @Test
    public void pasteTitleTest () {
        Assert.assertEquals(
                actualPasteResults.checkTitle(),
                pasteTitle,
                "Issue in field Title"
        );
    }

    @Test
    public void pasteTextTest (){
        Assert.assertEquals(
                actualPasteResults.checkText(),
                pasteText,
                "Issue in field Text"
        );
    }

    @Test
    public void pasteSyntaxHighlight () {
        Assert.assertEquals(
                actualPasteResults.checkSyntaxHighlight(),
                "Bash",
                "Issue in Syntax Highlight selection"
        );
    }

    @AfterTest (alwaysRun = true)
    private void browserTearDown () {
        driver.quit();
        driver = null;
    }
}
