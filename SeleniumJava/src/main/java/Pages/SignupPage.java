package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	public static void goToSignin(WebDriver driver, WebDriverWait wait) {
		
		// Click the link to the 'sign in' page
		WebElement signinLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.authwall-join-form__swap-cta .authwall-join-form__form-toggle--bottom.form-toggle")));
    	signinLink.click();  
	}
}
