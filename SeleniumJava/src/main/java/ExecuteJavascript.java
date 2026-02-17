import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteJavascript {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/modal");
    	
    	// Find the elements by id
    	WebElement modalOpenButton = driver.findElement(By.id("modal-button"));    	
    	WebElement modalCloseButton = driver.findElement(By.id("close-button"));
    	
    	// Open and close Modal =========================================================================================================
    	modalOpenButton.click();
    	
    	// modalCloseButton.click() does NOT work. Instead ...
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", modalCloseButton);
    	// arguments[0] is the first argument passed from Java to JavaScript (in this case, the modalCloseButton)
    	// So this line is basically saying modalCloseButton.click()
    	//JavascriptExecutor tells the browser to run this JavaScript code as if it came from the webpage
    	
    	//Close the browser
    	System.out.println("Process Complete");
    	Thread.sleep(1000);
    	driver.quit();
	}
}
