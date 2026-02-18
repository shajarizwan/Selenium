package Pages;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	public static void setProfilePic(WebDriver driver, WebDriverWait wait) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		WebElement addButton = driver.findElement(By.cssSelector("div.pv-top-card__photo-wrapper.ml0 div.pv-top-card__edit-photo.profile-photo-edit")); 
		
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", addButton);
		
		
    	// Get the path to the file to upload
    	URL picURL = ProfilePage.class.getClassLoader().getResource("ProfilePic.png");
    	String imagePath = new File(picURL.getPath()).getAbsolutePath();
    	System.out.println(imagePath);
    	
    	
		WebElement uploadButton = driver.findElement(By.cssSelector("input#image-selector__file-upload-input")); 
		uploadButton.sendKeys(imagePath);
		
		driver.findElement(By.cssSelector("button span.artdeco-button__text")).click(); 

	}
}
