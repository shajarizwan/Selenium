import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class KeyboardAndMouseInput  {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the 'Keyboard and Mouse Input' web page
    	driver.get("https://formy-project.herokuapp.com/keypress");

    	// Find the text input element by its id
    	WebElement NameField = driver.findElement(By.id("name"));
    	
    	// Enter a name into the text input field
    	NameField.click();
    	NameField.sendKeys("Slinky San");
    	
    	// Click the submit button 
    	WebElement Button= driver.findElement(By.id("button"));
    	Button.click();
    
    	// Wait for 2 seconds
    	Thread.sleep(2000);

    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
