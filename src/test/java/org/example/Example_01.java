package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Example_01 {

    @Test
    public void Linktext() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://event-management-lac-eight.vercel.app/login");
        driver.findElements(By.tagName("a"));
        Thread.sleep(2000);
        List<WebElement> link = driver.findElements(By.tagName("a"));
        Thread.sleep(2000);
        System.out.println(link.size());
        for (int i =0;i<link.size();i++){
            System.out.println(link.get(i).getText());
            System.out.println(link.get(i).getAttribute("href"));

            if (link.get(i).getText().equalsIgnoreCase("Forgot Password?")){
                link.get(i).click();
            }
        }
    }
}