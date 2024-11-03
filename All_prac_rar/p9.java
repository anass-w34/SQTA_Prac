package p9;

//File: ActionClassDemo.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClassDemo_sele {
 public static void main(String[] args) {
     // Set up ChromeDriver (replace with the correct driver path)
     System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     Actions actions = new Actions(driver);

     // Navigate to the Selenium Mouse Interaction page
     driver.get("https://selenium.dev/selenium/web/mouse_interaction.html");

     try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // 1. Click on a button
         WebElement clickButton = driver.findElement(By.linkText("Click for Results Page"));
         actions.click(clickButton).perform();
         System.out.println("Performed click on the 'Click for Results Page' link");

         // Navigate back to reset the page for further interactions
         driver.navigate().back();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click for Results Page")));

         // 2. Double-click on the page
         WebElement doubleClickArea = driver.findElement(By.cssSelector("body"));
         actions.doubleClick(doubleClickArea).perform();
         System.out.println("Performed double-click on the page");

         // 3. Right-click (context-click) on the page
         actions.contextClick(doubleClickArea).perform();
         System.out.println("Performed right-click on the page");

         // 4. Hover over the 'Move mouse here' text element
         WebElement hoverElement = driver.findElement(By.xpath("//div[contains(text(),'Move mouse here.')]"));
         actions.moveToElement(hoverElement).perform();
         System.out.println("Hovered over the 'Move mouse here' element");

         // 5. Drag and drop (source and target corrected)
         WebElement sourceElement = driver.findElement(By.id("draggable"));   // Corrected to use ID "draggable"
         WebElement targetElement = driver.findElement(By.id("droppable"));   // Corrected to use ID "droppable"
         actions.dragAndDrop(sourceElement, targetElement).perform();
         System.out.println("Performed drag and drop from 'Draggable' to 'Droppable'");

     } catch (Exception e) {
         System.out.println("An error occurred: " + e.getMessage());
     } finally {
         // Close the driver
         driver.quit();
     }
 }
}
