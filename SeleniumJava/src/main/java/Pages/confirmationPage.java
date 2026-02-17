package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class confirmationPage {
	public static void waitForSuccessBanner(WebDriver driver, WebDriverWait wait){
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
	}
	
	public static String getConfirmationText(WebDriver driver){
		return driver.findElement(By.className("alert")).getText();
	}
}
