package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example {
    @Test
    public void validLogin() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://event-management-lac-eight.vercel.app/login");

        driver.findElement(By.xpath("//input[@type='email']"))

                .sendKeys("artifactgeekscompany@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Enter your password']")).
                sendKeys("Admin@123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Enter your password']"))
                .sendKeys("Admin@123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(2000);
        // Step 1: Profile / User menu par click
        driver.findElement(By.xpath("//div[text()='Kuldeep Kumawat']")).click();

// Step 2: Sign Out par click
        driver.findElement(By.xpath("//button[text()='Sign Out']")).click();

    }
}
