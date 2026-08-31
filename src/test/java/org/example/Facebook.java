package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.Arrays;

public class Facebook {

    @Test
    public void Login_facebook() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://dev-pawan.devhub.lrinternal.com/auth.aspx");
        driver.manage().window().maximize();
        String parent_Window = driver.getWindowHandle();


        driver.findElement(By.xpath("//*[@id=\"interfacecontainerdiv\"]/span[5]")).click();
// Get all window handles and store in array
        String[] windows = driver.getWindowHandles()
                .toArray(new String[0]);

        System.out.println("Parent windows: " + parent_Window);
        System.out.println("Current windows: " + windows[1]);

        driver.switchTo().window(windows[1]);
        Thread.sleep(5000);


        // Enter Facebook email
        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys("test@mail.com");
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys("password123456");

        driver.findElement(By.xpath("//span[text()='Log in']")).click();

       // driver.switchTo().window(parent_Window);


    }
}
