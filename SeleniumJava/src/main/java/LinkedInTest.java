import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.FeedPage;
import Pages.ProfilePage;
import Pages.SigninPage;
import Pages.SignupPage;

public class LinkedInTest {
	public static void main(String[] args) throws InterruptedException {
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Widen the browser window
		driver.manage().window().setSize(new Dimension(1400, 900));
		
		// Create new instance of wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
    	// Visit the Linkedin Signup Page
    	driver.get("https://www.linkedin.com/authwall");
    	
    	SignupPage.goToSignin(driver, wait);
    	SigninPage.signin(driver, "ncheerwine@gmail.com", "TestPass");
    	FeedPage.goToProfile(driver, wait);
    	ProfilePage.setProfilePic(driver, wait);
    	
    	// Wait for 2 seconds
        Thread.sleep(100000);
    	
    	
//    	confirmationPage.waitForSuccessBanner(driver, wait);
//    	String returnedText = confirmationPage.getConfirmationText(driver);
//    	
//    	// Add assertion for successfully submitting the form 
//    	String expectedText = "The form was successfully submitted!";
//		assertEquals(expectedText, returnedText);
//		System.out.println(returnedText);
    	
    	//Close the browser
    	driver.quit();
	}
}
