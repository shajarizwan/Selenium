import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/dropdown");
    	
    	// Find and open the dropdown menu 
    	WebElement dropdownButton = driver.findElement(By.id("dropdownMenuButton"));  
    	dropdownButton.click();
    	Thread.sleep(2000);
    	
    	// Once the menu is open, select the 8th item from the menu
    	WebElement dropdownSelection = driver.findElement(By.cssSelector("div.dropdown-menu.show a:nth-child(8)"));
    	dropdownSelection.click();
    	Thread.sleep(2000);

    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
