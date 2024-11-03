package p3;

//File: NavigationAndBrowserCommands.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class NavigationAndBrowserCommands_selenium {

 public static void main(String[] args) {

     // Set System Property for ChromeDriver (update path if necessary)
     System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

     // Initialize ChromeDriver
     WebDriver driver = new ChromeDriver();

     try {
         // Set an implicit wait time
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         // Step 1: Navigate to Selenium's main page
         driver.navigate().to("https://www.selenium.dev");
         System.out.println("Opened URL: " + driver.getCurrentUrl());

         // Print the page title using Browser Command
         System.out.println("Page Title: " + driver.getTitle());

         // Step 2: Navigate to a specific page (Selenium WebDriver page)
         driver.navigate().to("https://www.selenium.dev/documentation/webdriver/");
         System.out.println("Navigated to URL: " + driver.getCurrentUrl());

         // Print the page title of the new page
         System.out.println("Page Title after navigation: " + driver.getTitle());

         // Step 3: Go back to the previous page
         driver.navigate().back();
         System.out.println("Navigated back to URL: " + driver.getCurrentUrl());
         System.out.println("Page Title after back navigation: " + driver.getTitle());

         // Step 4: Go forward to the Selenium WebDriver page again
         driver.navigate().forward();
         System.out.println("Navigated forward to URL: " + driver.getCurrentUrl());
         System.out.println("Page Title after forward navigation: " + driver.getTitle());

         // Step 5: Refresh the current page (Selenium WebDriver page)
         driver.navigate().refresh();
         System.out.println("Page refreshed at URL: " + driver.getCurrentUrl());

         // Step 6: Print current URL and page title after refresh
         System.out.println("Page Title after refresh: " + driver.getTitle());

     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         // Close the browser using Browser Command
         driver.quit();
     }
 }
}
