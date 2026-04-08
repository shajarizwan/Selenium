import java.io.*;
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

	private static final String DATASETS_EXE = "C:\\Users\\srizwan\\Desktop\\old projects\\Selenium\\SeleniumMOA\\src\\main\\resources\\datasets.exe";

    public static void downloadGenome(String accession, String speciesName) throws IOException, InterruptedException {
        // Sanitize species name for use as a filename (replace spaces with underscores)
        String safeSpeciesName = speciesName.replace(" ", "_");
        String outputFile = safeSpeciesName + ".zip";

        ProcessBuilder pb = new ProcessBuilder(
            DATASETS_EXE, "download", "genome", "accession", accession,
            "--include", "genome",
            "--filename", outputFile
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Stream output to console
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[" + speciesName + "] " + line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Downloaded: " + outputFile);
        } else {
            System.err.println("Download failed for " + speciesName + " (exit code " + exitCode + ")");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        List<String> SPECIES_LIST = List.of(
                "fake species",
                "Candidatus Fermentibacterota bacterium",
                "Drosophila Melanogaster",
                "Encephalitozoon cuniculi");

        Map<String, String> accessions = new HashMap<>();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        for (String SPECIES : SPECIES_LIST) {
            driver.get("https://www.ncbi.nlm.nih.gov/datasets/genome/");

            Boolean genomeFound = GenomeSearchPage.searchFor(driver, wait, SPECIES);

            if (genomeFound) {
                Boolean verifiedAssemblyFound = SearchResultsPage.clickVerifiedAssembly(driver, wait, SPECIES);
                if (verifiedAssemblyFound) {
                    String accession = AssemblyPage.getAccession(driver, wait);
                    accessions.put(SPECIES, accession);
                }
            }
        }

        driver.quit();

        // Download each genome
        System.out.println("\n--- Starting Downloads ---");
        for (Map.Entry<String, String> entry : accessions.entrySet()) {
            System.out.println("Downloading " + entry.getKey() + " (" + entry.getValue() + ")");
            downloadGenome(entry.getValue(), entry.getKey());
        }

        System.out.println("Process Complete");
    }
}