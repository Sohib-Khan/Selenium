package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

public class Example_04 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://event-management-lac-eight.vercel.app/login");

        // Parent window
        String parentWindow = driver.getWindowHandle();


        String title = driver.getTitle();
        System.out.println(title);

        // Click "Sign in with Google"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'Sign in with Google')]")
        )).click();

        // Wait for Google popup/window
        wait.until(driver1 -> driver.getWindowHandles().size() > 1);

        // Switch to Google window
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Email / Phone field
        WebElement email = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("identifierId")
                )
        );

        email.click();
        email.sendKeys("tanmaymk03@gmail.com");

        // Next button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[normalize-space()='Next']]")

        )).click();
        String title1 = driver.getTitle();
        System.out.println(title);

        System.out.println("Email entered and Next clicked.");
    }
    }