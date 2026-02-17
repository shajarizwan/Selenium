import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public static void main(String[] args) {
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();
		
    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/autocomplete");
    	
    	// Get address field element
    	WebElement addressField = driver.findElement(By.id("autocomplete"));  
    	
    	// Upload the file and click the reset button
    	addressField.sendKeys("8426 Penton Place");
    	
    	// ========================================================================================================================
    	// Add an implicit wait for 5 seconds. 
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    	// Click the autocomplete element
//    	WebElement autocompleteResult = driver.findElement(By.className("dismissButton"));
//        autocompleteResult.click();
   	
    	// Add an explicit wait 
    	// Create a new WebDriverWait object that waits for 10 seconds max
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement autocompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dismissButton")));
		autocompleteResult.click();
		
		// ========================================================================================================================

    	
    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
