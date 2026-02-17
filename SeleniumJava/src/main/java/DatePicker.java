import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/datepicker");
    	
    	// Find the input elements by various selectors. 
    	WebElement dateField = driver.findElement(By.id("datepicker"));  
 
    	
    	// Click the buttons
    	dateField.click();
    	dateField.sendKeys("08/01/1999");
    	dateField.sendKeys(Keys.RETURN);
    	
    	Thread.sleep(2000);


    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
