import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class OpenGoogle {
    public static void main(String[] args) throws InterruptedException {

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Hello from Slinky!");

        // Now submit the form
        element.submit();
        
        // Wait for 2 seconds
        Thread.sleep(2000);

        //Close the browser
        System.out.println("Process Complete");
        driver.quit();
    }
}
