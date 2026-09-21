package org.example;

import com.google.j2objc.annotations.Weak;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registration_page {
    @Test
    public void LoginForm() throws InterruptedException {

        // Open The Browser
        WebDriver driver = new FirefoxDriver();
        // Enter the Url
        driver.get("file:///C:/Users/abc/OneDrive/Documents/Registration%20Page.html");

        //  Enter the First Name *
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Sohib");
        Thread.sleep(5000);
        // Enter the Last Name
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Khan");
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("Sohibkhan@gmail.com");
        driver.findElement(By.xpath("//*[@type='tel']")).sendKeys("9145921300");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Sohib");
        driver.findElement(By.xpath("//*[@id='confirmPassword']")).sendKeys("Sohib");
        driver.findElement(By.id("dob")).sendKeys("2000-01-15");
        driver.findElement(By.xpath("//*[@type='number']")).sendKeys("20");
        driver.findElement(By.xpath("//*[@type='radio']")).click();
        driver.findElement(By.xpath("//*[@id='address']")).sendKeys("Jaipur Rajsathan ");

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@type='date']"))));

       WebElement Element_select = driver.findElement(By.xpath("//*[@id='country']"));
        Select select= new Select(Element_select);
      //  select.selectByVisibleText("India");
        select.selectByIndex(1);

        WebElement Element_select1 = driver.findElement(By.xpath("//*[@id='state']"));
        Select state = new Select(Element_select1);
        state.selectByIndex(1);

        driver.findElement(By.id("city")).sendKeys("Dholpur");
        driver.findElement(By.id("pincode")).sendKeys("3321654");

        Select country = new Select(driver.findElement(By.id("qualification")));
        country.selectByVisibleText("BCA");

        driver.findElement(By.id("experience")).sendKeys("3");

        Select Course = new Select(driver.findElement(By.id("course")));
        Course.selectByVisibleText("Automation with Playwright");

        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("skillJava"))));

        driver.findElement(By.id("skillJava")).click();

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("newsletter")).click();
       // driver.findElement(By.id("skillSelenium")).click();

        driver.findElement(By.id("btnRegister")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));

        String Expected ="Registration submitted successfully!";
        String Actual = driver.findElement(By.id("successMessage")).getText();
        System.out.println("Exepected Result :- " +Expected);
        System.out.println("Actual Result :-"+Actual);
        Assert.assertEquals(Actual,Expected);
        driver.quit();

    }
}
