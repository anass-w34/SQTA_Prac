package p4;

//File: LocateElementsExample.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LocateElementsExample {

 public static void main(String[] args) {

     // Set System Property for ChromeDriver (update path if necessary)
     System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

     // Initialize ChromeDriver
     WebDriver driver = new ChromeDriver();

     try {
         // Step 1: Launch Wikipedia's main page
         driver.get("https://www.wikipedia.org");

         // Wait to ensure elements are loaded
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

         // 1. Locate by ID - "searchInput" (for the main search box on Wikipedia homepage)
         WebElement elementByID = driver.findElement(By.id("searchInput"));
         System.out.println("Located by ID: " + elementByID.getTagName());

         // 2. Locate by Name - "search" (for the search form's name attribute)
         WebElement elementByName = driver.findElement(By.name("search"));
         System.out.println("Located by Name: " + elementByName.getAttribute("name"));

         // 3. Locate by Class Name - "central-featured-logo" (for the Wikipedia logo image)
         WebElement elementByClassName = driver.findElement(By.className("central-featured-logo"));
         System.out.println("Located by Class Name: " + elementByClassName.getTagName());

         // 4. Locate by Tag Name - "h1" (for the main page heading, "Wikipedia")
         WebElement elementByTagName = driver.findElement(By.tagName("h1"));
         System.out.println("Located by Tag Name: " + elementByTagName.getText());

         // 5. Locate by Link Text - "English" (for the link to the English Wikipedia)
//        WebElement elementByLinkText = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Italiano")));
//        System.out.println("Located by Link Text: " + elementByLinkText.getText());

         // 6. Locate by Partial Link Text - "EspaÃ±ol" (for the Spanish Wikipedia link)
         WebElement elementByPartialLinkText = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Español")));
         System.out.println("Located by Partial Link Text: " + elementByPartialLinkText.getText());
         Thread.sleep(5000);

         // 7. Locate by CSS Selector - ".other-projects" (for the footer section with class "other-projects")
         WebElement elementByCSS = driver.findElement(By.cssSelector(".other-projects"));
         System.out.println("Located by CSS Selector: " + elementByCSS.getTagName());

//      8. Locate by XPath using text()
//         WebElement elementByXPath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Wikipedia']")));
//         System.out.println("Located by XPath using text(): " + elementByXPath.getText());





     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         // Close the browser
         driver.quit();
     }
 }
}
