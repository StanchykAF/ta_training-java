package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PastebinPasteResultPage {

    private WebDriver driver;
    private String pasteText;
    private String pasteTitle;

    public PastebinPasteResultPage (WebDriver driver, String pasteText, String pasteTitle) {
        this.driver = driver;
        this.pasteText = pasteText;
        this.pasteTitle = pasteTitle;
        PageFactory.initElements(driver, this);
    }

    public List<String> checkPaste() {
        List<String> pasteResults = new ArrayList<>();
        pasteResults.add(checkTitle());
        pasteResults.add(checkSyntaxHighlight());
        pasteResults.add(checkText());
        return pasteResults;
    }

    public String checkTitle () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".info-top h1")))
                .getText();
    }

    public String checkSyntaxHighlight () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']/a[@class='btn -small h_800']")))
                .getText();
    }

    public String checkText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"highlighted-code\"]/div[@class=\"source\"]")))
                .getText();
    }
}
