package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ex_1 {
    @Test
    public void test_js() {

        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.location = 'https://www.google.com'");

        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));

       js.executeScript("window.scrollBy(0, 2000);");
       js.executeScript("window.scrollBy(0, 500);");
   //     driver.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/div/div[1]/div[2]/div/div/button")).click();

        String url = js.executeScript("return document.URL;").toString();
        String title = js.executeScript("return document.title;").toString();

        System.out.println(url);
        System.out.println(title);


      //closeBrowser(driver);
    }
    }
