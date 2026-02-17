import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.FormPage;
import Pages.confirmationPage;
public class SignupForm {
	public static void main(String[] args) {
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Create new instance of wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
    	// Visit the web page
    	driver.get("https://formy-project.herokuapp.com/form");
    	
    	// Submit the form and assert success
    	FormPage.submitForm(driver, wait);
    	confirmationPage.waitForSuccessBanner(driver, wait);
    	String returnedText = confirmationPage.getConfirmationText(driver);
    	
    	// Add assertion for successfully submitting the form 
    	String expectedText = "The form was successfully submitted!";
		assertEquals(expectedText, returnedText);
		System.out.println(returnedText);
    	
    	//Close the browser
    	driver.quit();
	}
}
