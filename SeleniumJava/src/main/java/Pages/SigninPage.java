package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {
	public static void signin(WebDriver driver, String email, String password){
		
		// Fill out the form with username and password, and hit submit
    	driver.findElement(By.id("session_key")).sendKeys(email); 
    	driver.findElement(By.id("session_password")).sendKeys(password); 
    	driver.findElement(By.cssSelector("[data-id='sign-in-form__submit-btn']")).click(); 
	}
}
