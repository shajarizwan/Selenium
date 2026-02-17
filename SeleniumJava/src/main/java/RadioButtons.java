import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/radiobutton");
    	
    	// Find the input elements by various selectors. 
    	WebElement RadioButton1 = driver.findElement(By.id("radio-button-1"));    	
    	WebElement RadioButton2 = driver.findElement(By.cssSelector(".form-check-input[value='option2']"));  
    	WebElement RadioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));  
 
    	
    	// Click the buttons
    	RadioButton1.click();
    	Thread.sleep(1000);
    	RadioButton2.click();
    	Thread.sleep(1000);
    	RadioButton3.click();
    	Thread.sleep(1000);


    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
