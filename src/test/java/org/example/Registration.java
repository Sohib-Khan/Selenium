package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Registration {
    @Test
    public void ValidEmailandpassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //Enter the  url
        driver.get("C:/Users/abc/Downloads/Demo.html");
        //Click Create New Account
        driver.findElement(By.id("show-register")).click();


        // Enter the name
        driver.findElement(By.id("register-name")).sendKeys("Sohib");

        //Enter the  Email
        driver.findElement(By.id("register-email")).sendKeys("sohib@gmailcom");

        //Enter the  Phone number
        driver.findElement(By.id("register-phone")).sendKeys("12345677");

        //Enter the  PassWord
        driver.findElement(By.id("register-password")).sendKeys("123456");

        // Enter Confirm Password
        driver.findElement(By.id("confirm-password")).sendKeys("123456");

        // Click Register button
        driver.findElement(By.id("register-button")).click();

        Thread.sleep(2000);
          driver.quit();
    }

}
