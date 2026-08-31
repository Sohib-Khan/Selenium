package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice_Selenium_Project_01 {

    @Test
    public void invalidLoginTestvwo()throws InterruptedException{
        // Open the Browser
        WebDriver driver = new FirefoxDriver();

        // Enter the URl
        driver.get("https://app.vwo.com/#/login");
        // Enter The username and email
        driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("Adminname");
        //Enter  the invalid password
        driver.findElement(By.xpath("//*[@id='login-password'   ]")).sendKeys("Sohibkhan");
        // Click in sign in
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
//      message verify
        String ExpectederrorMessage = "Your email, password, IP address or location did not match";
       String ActualErrorMessage = driver.findElement(By.id("js-notification-box-msg")).getText();
       System.out.println("Expected " + ExpectederrorMessage );
        System.out.println("Actual " + ActualErrorMessage );
        Assert.assertEquals(ActualErrorMessage,ExpectederrorMessage);

        Thread.sleep(2000);
        driver.quit();

    }

}
