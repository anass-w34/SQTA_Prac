package p5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LocatorPractice{
    public static void main(String[] args) {
        // Set up ChromeDriver (replace with the correct driver path)
        System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Wait setup for elements to be located
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Example domain website
        driver.get("https://example.com");

        try {
            // 1. Locating by Tag Name (Using `<h1>` tag)
            WebElement elementByTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

            // 2. Locating by Link Text (Using "More information...")
            WebElement elementByLinkText = driver.findElement(By.linkText("More information..."));

            // 3. Locating by Partial Link Text (Using "More")
            WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("More"));

            // 4. Locating by CSS Selector (Using `<p>` tag with CSS selector)
            WebElement elementByCss = driver.findElement(By.cssSelector("p"));

            // 5. Locating by XPath (Using XPath for the first `<a>` tag)
            WebElement elementByXPath = driver.findElement(By.xpath("//a[contains(text(),'More information...')]"));

            // 6. Locating by DOM - getElementById using JavaScript (for `h1` tag directly by tag)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement elementByDomId = (WebElement) js.executeScript("return document.getElementsByTagName('h1')[0];");

            // Example interaction with the located elements
            if (elementByTag != null) {
                System.out.println("Located element by Tag Name (h1)");
                System.out.println("Text of element: " + elementByTag.getText());
            }

            if (elementByLinkText != null) {
                System.out.println("Located element by Link Text (More information...)");
            }

        } catch (NoSuchElementException e) {
            System.out.println("An element could not be found: " + e.getMessage());
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
