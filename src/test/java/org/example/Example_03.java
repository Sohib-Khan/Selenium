package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Example_03 {

    @Test
    public void login1() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        String URL = "https://www.spicejet.com/";
        driver.get(URL);

        // 1. Actions class ka object banayein
        Actions actions = new Actions(driver);
     //Thread.sleep(3000);
// 2. Element find karein (using the custom attribute you provided)
        WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));
      //  Thread.sleep(3000);
// 3. Mouse ko element par le jayein, click karein, aur "BLR" send karein
        actions.moveToElement(destination)
                .click().sendKeys("BLR").build().perform();

//        actions.clickAndHold(destination).keyDown(Keys.SHIFT)
//
//                .click().sendKeys("blr").build().perform();

        WebElement rightClickBtn = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

// Element par right click karne ke liye
        actions.contextClick(rightClickBtn).perform();
    }
}
