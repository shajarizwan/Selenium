import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.ProfilePage;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException{
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();

    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/fileupload");
    	
    	// Get elements
    	WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));  
    	WebElement resetButton = driver.findElement(By.cssSelector(".btn.btn-warning.btn-reset"));  
    	
    	// Get the path to the file to upload
    	// Get the path to the file to upload
    	URL pic = FileUpload.class.getClassLoader().getResource("file-to-upload.png");
    	String imagePath = new File(pic.getPath()).getAbsolutePath();
    	System.out.println(imagePath);
    	
    	// Upload the file and click the reset button
    	fileUploadField.sendKeys(imagePath);
    	Thread.sleep(1000);
    	
    	resetButton.click();
    	Thread.sleep(1000);

    	//Close the browser
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
