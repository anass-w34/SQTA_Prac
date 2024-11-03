package p8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RadioButtonDemo {
    public static void main(String[] args) {
        // Set up ChromeDriver (replace with the correct driver path)
        System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the Guru99 demo page
        driver.get("https://demo.guru99.com/test/radio.html");

        try {
            // Initialize Explicit Wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. Handling Radio Buttons
            WebElement radio1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("vfb-7-1"))); // Radio button Option 1
            WebElement radio2 = driver.findElement(By.id("vfb-7-2")); // Radio button Option 2

            // Click on the first radio button
            radio1.click();
            System.out.println("Selected Radio Button Option 1");

            // 2. Handling Checkboxes
            WebElement checkbox1 = driver.findElement(By.id("vfb-6-0")); // Checkbox 1
            WebElement checkbox2 = driver.findElement(By.id("vfb-6-1")); // Checkbox 2

            // Select the checkboxes
            checkbox1.click();
            System.out.println("Selected Checkbox 1");
            checkbox2.click();
            System.out.println("Selected Checkbox 2");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
