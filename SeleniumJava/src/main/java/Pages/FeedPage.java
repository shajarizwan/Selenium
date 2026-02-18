package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeedPage {
	public static void goToProfile(WebDriver driver, WebDriverWait wait){
		// Go to profile page  
		WebElement profilePic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._6fc68c2a.fe05435b.def7e651._19805243._9749b885._8f2a9cbe._05265161")));
		profilePic.click(); 
	}
}
