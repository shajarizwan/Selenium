package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssemblyPage {
	public static String getAccession(WebDriver driver, WebDriverWait wait ){
		
    	// Try to get NCBI RefSeq assembly
		
		WebElement accessionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("[data-testid='description_list'] dd:first-of-type span")));
		
    	String accessionText = accessionElement.getText();  
    	
    	return accessionText;
    	
	}
}
