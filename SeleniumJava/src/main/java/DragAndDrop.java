import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the 'Large Page Content' web page
    	driver.get("https://formy-project.herokuapp.com/dragdrop");
    	
    	// Find the elements by id
    	WebElement image = driver.findElement(By.id("image"));    	
    	WebElement box = driver.findElement(By.id("box"));
    	
    	// Drag image into box =========================================================================================================
    	Actions actions = new Actions(driver);
    	actions.dragAndDrop(image, box).build().perform();
    	
    	// Get the text from the <p> element inside the box
    	WebElement successMessageElement = driver.findElement(By.cssSelector("#box p"));
    	String successMessage = successMessageElement.getText();
    	
    	//Close the browser
    	System.out.println(successMessage);
    	Thread.sleep(1000);
    	driver.quit();
	}
}
