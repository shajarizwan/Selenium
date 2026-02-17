import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Selenium WebDriver assigns each window a unique ID
public class SwitchTo {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/switch-window");
    	
    	// Find the elements by id
    	WebElement newTabButton = driver.findElement(By.id("new-tab-button"));    	
    	WebElement openAlertButton = driver.findElement(By.id("alert-button"));
    	
    	// Open a new tab =========================================================================================================
    	newTabButton.click();
    	
    	String originalHandle = driver.getWindowHandle();
    	
    	// getWindowHandles() returns a Set<String> containing unique indentifiers (handlers) for all currently open tabs. 
    	for(String handle: driver.getWindowHandles()) {
    		// For each tab in the currently open tabs, switch to that tab. The for-loop ends on the last opened tab. 
            driver.switchTo().window(handle);
        }
    	
    	// Switch back to the original tab
    	Thread.sleep(1000);
    	driver.switchTo().window(originalHandle);
    	
    	// Open an alert =========================================================================================================
    	openAlertButton.click();
    	
    	// define a new alert object
    	// driver.switchTo().alert() switches the WedDriver's focus from the main web page to the alert dialog that is currently displayed 
    	// Alert alert = ... stores a reference to the alert in a variable of type 'Alert' 
    	Alert alert = driver.switchTo().alert();
    	
    	// Clicks the 'OK' button on the alert dialog. 
    	Thread.sleep(1000);
    	alert.accept();
    	
    	//Close the browser
    	System.out.println("Process Complete");
    	Thread.sleep(1000);
    	driver.quit();
	}
}
