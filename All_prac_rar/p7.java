package p7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandlingBStackDemo {
    public static void main(String[] args) {
        // Set up ChromeDriver (replace with the correct driver path)
        System.setProperty("webdriver.chrome.driver", "C:/Users/Huda/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the demo site
        driver.get("https://www.bstackdemo.com");

        try {
            // Initialize JavaScript Executor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 1. Handling the Sort Dropdown (Order by Lowest to Highest)
            WebElement sortDropdown = driver.findElement(By.cssSelector(".sort select"));
            Select selectSort = new Select(sortDropdown);

            // Select by value for sorting (e.g., 'lowestprice' for Lowest to Highest)
            selectSort.selectByValue("lowestprice");
            System.out.println("Sorted products by 'Lowest to Highest'");
            Thread.sleep(5000);

            // 2. Handling Vendor Selection (Checkbox Selection for Apple using JavaScript)
            WebElement appleCheckbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='Apple']"));
            
            // Use JavaScript to click on the checkbox if not already selected
            if (!appleCheckbox.isSelected()) {
                js.executeScript("arguments[0].click();", appleCheckbox);
            }
            Thread.sleep(5000);
            System.out.println("Selected 'Apple' from vendor filters");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
