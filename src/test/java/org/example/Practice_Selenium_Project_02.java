package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class Practice_Selenium_Project_02 {

    @Test
    public void ValidUsername() throws InterruptedException {
        //Open the browser
        WebDriver driver = new ChromeDriver();
        //Enter the url
        Thread.sleep(2000);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Enter the Username
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("username"))));
        // 2. Enter Username
        driver.findElement(By.name("username")).sendKeys("Admin");

        // 3. Enter Password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // 4. Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        // 5. Print Dashboard URL
        System.out.println("Dashboard URL : " + driver.getCurrentUrl());

        // 6. Click User Dropdown
        driver.findElement(By.className("oxd-userdropdown-tab")).click();

        Thread.sleep(1000);

        // 7. Click Logout
        driver.findElement(By.xpath("//a[normalize-space()='Logout']"))
                .click();
        driver.quit();

    }
}