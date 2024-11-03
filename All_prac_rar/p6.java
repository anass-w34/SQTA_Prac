package p6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertHandlingDemo {
    public static void main(String[] args) {
        // Set up ChromeDriver (replace with the correct driver path)
        System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the alert demonstration page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        try {
            // 1. Handling a Simple Alert
            WebElement simpleAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
            simpleAlertButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Simple Alert Text: " + simpleAlert.getText());
            Thread.sleep(5000);
            simpleAlert.accept();

            // 2. Handling a Confirmation Alert (Accept)
            WebElement confirmAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            confirmAlertButton.click();

            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
            Thread.sleep(5000);
            confirmAlert.accept();  // Accept the confirmation alert

            // 3. Handling a Confirmation Alert (Dismiss)
            confirmAlertButton.click();
            confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
            Thread.sleep(5000);
            confirmAlert.dismiss();  // Dismiss the confirmation alert

            // 4. Handling a Prompt Alert
            WebElement promptAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
            promptAlertButton.click();

            Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Prompt Alert Text: " + promptAlert.getText());
            promptAlert.sendKeys("Selenium Test");  // Enter text into the prompt alert
            promptAlert.accept();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
