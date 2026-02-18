
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaTest {
    public static void main(String[] args) throws InterruptedException {

        // Start browser
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open Wikipedia homepage
        driver.get("https://www.wikipedia.org");

        // Wait for search box and enter the query
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
        searchBox.sendKeys("Selenium (software)");
        searchBox.submit();

        // Wait for the article heading
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstHeading")));

        // Locate first paragraph of the article
        String firstParagraph = driver.findElement(By.cssSelector("div.mw-parser-output > p:nth-of-type(2)")).getText();

        // Go to text editor website and enter the wikipedia text
        driver.get("https://www.editpad.org/");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("textarea__editor"))).sendKeys(firstParagraph);
        
        Thread.sleep(10000);
            
        driver.quit();
    }
}
