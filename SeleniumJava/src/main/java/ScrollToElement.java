import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/scroll");
    	
    	// Find the input elements by id
    	WebElement NameField = driver.findElement(By.id("name"));    	
    	WebElement DateField = driver.findElement(By.id("date"));
    	
    	// Scroll to the bottom of the page
    	Actions actions = new Actions(driver);
    	actions.moveToElement(NameField);
    	
    	// Enter text into the text input fields
    	NameField.click();
    	NameField.sendKeys("Slinky San");
    	
    	DateField.click();
    	DateField.sendKeys("08/01/1999");
    
    	// Wait for 2 seconds
    	Thread.sleep(2000);

    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
