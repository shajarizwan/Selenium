package Pages;


import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	public static boolean clickVerifiedAssembly(WebDriver driver, WebDriverWait wait, String species){
    	
		try {
			// Find the verified icon, and click the 'a' element that is the child of the same parent as the verified icon. 
			WebElement verifiedAssembly = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.cssSelector("[data-testid='VerifiedIcon']")))
					.findElement(By.xpath("../a"));
			verifiedAssembly.click();	
			return true;
		} catch (TimeoutException e) {
			System.out.println(species + ": " + String.format("No verified assembly for %s", species));
			return false;
		}
	}
}
