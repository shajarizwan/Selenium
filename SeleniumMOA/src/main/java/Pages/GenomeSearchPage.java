package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenomeSearchPage {

	public static boolean searchFor(WebDriver driver, WebDriverWait wait, String searchTerm){
    	// Get search field element
    	WebElement searchField = driver.findElement(By.id("taxonomy_autocomplete"));  
    	
    	// Enter the search term into the search field and click 'search'
    	searchField.sendKeys(searchTerm);
    	WebElement searchButton = driver.findElement(By.cssSelector("[data-testid='genome-home-search']"));
    	searchButton.click();
    	
    	try {
    		WebElement muiAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div .MuiAlert-message")));
    		System.out.println(muiAlert.getText());
    		return false;
    	} catch (TimeoutException e) {
			return true;
		}
	}
}
