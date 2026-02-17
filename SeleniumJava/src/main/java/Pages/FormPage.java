package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
	public static void submitForm(WebDriver driver, WebDriverWait wait){
		// Fill out the form 
    	driver.findElement(By.id("first-name")).sendKeys("Slinky");  
    	driver.findElement(By.id("last-name")).sendKeys("San"); 
    	driver.findElement(By.id("job-title")).sendKeys("Slinker"); 
    	driver.findElement(By.id("radio-button-3")).click(); 
    	driver.findElement(By.id("checkbox-2")).click(); 
    	driver.findElement(By.id("select-menu")).click(); 
    	
    	// Add an explicit wait 
		WebElement menuOption2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select-menu option[value = '1']")));
		menuOption2.click();
		
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.sendKeys("08/01/1999");
		datePicker.sendKeys(Keys.RETURN);
		
		// Submit the form 
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click(); 
	}
}
