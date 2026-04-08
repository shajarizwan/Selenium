import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.GenomeSearchPage;
import Pages.SearchResultsPage;
import Pages.AssemblyPage;

public class DownloadFullGenome {
	public static void main(String[] args) throws InterruptedException {
		
		List<String> SPECIES_LIST = List.of(
				"fake species", 
				"Candidatus Fermentibacterota bacterium", 
				"Drosophila Melanogaster",
				"Avena Sativa");
		
		Map<String, String> accessions = new HashMap<>();
		
		// Create new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Create new instance of WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		for (String SPECIES : SPECIES_LIST) {
		// Visit the genome search page
			driver.get("https://www.ncbi.nlm.nih.gov/datasets/genome/");
    	
    		Boolean genomeFound= GenomeSearchPage.searchFor(driver, wait, SPECIES);
    	
    		if (genomeFound) {
    			Boolean verifiedAssemblyFound = SearchResultsPage.clickVerifiedAssembly(driver, wait, SPECIES);
    			if (verifiedAssemblyFound) {
    				String accession = AssemblyPage.getAccession(driver, wait);
    				accessions.put(SPECIES, accession);
    			}
    		}
		}
		
		// Print out the accessions hashmap
		accessions.forEach((key, value) -> System.out.println(key + " : " + value));
		
    	// Add an implicit wait for 5 seconds. 
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	//Close the browser
    	Thread.sleep(5000);
    	System.out.println("Process Complete");
    	driver.quit();
	}
}
