package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Practice_Selenium_Project_03 {
    @Test
    public void ValidEmailandpassword() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        //Enter the  url
        driver.get("C:/Users/abc/Downloads/Demo.html");

        //Enter Email
        driver.findElement(By.id("login-email")).sendKeys("Sohib@gmailcom");
        // Enter the  password
        driver.findElement(By.id("login-password")).sendKeys("12345");

        Thread.sleep(2000);
        // click the login page
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);
        driver.quit();






    }
}
