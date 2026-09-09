package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Google {
    @Test
    public void Search() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");


        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Selenium");
        // Wait for suggestions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Actual suggestions
        List<WebElement> suggestions = driver.findElements(
                By.xpath("//ul[@role='listbox']//div[@role='option']")
        );

        int count = 0;

        for (WebElement suggestion : suggestions) {

            if (suggestion.isDisplayed()) {

                String text = suggestion.getText().trim();

                if (!text.isEmpty()) {
                    count++;
                    System.out.println(count + ". " + text);
                }
            }
        }

        System.out.println("Total Visible Suggestions: " + count);


        suggestions.get(3).click();

        // driver.quit();
    }
}
