package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Example_05 {

    @Test
    public void login() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // 1. Website open karo
        driver.get("https://the-internet.herokuapp.com/windows");

        // 2. Parent Window (Current Tab) ki ID save kar lo, taaki wapas aa sakein
        String parentWindowId = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindowId);

        // 3. Link par click karo jisse naya tab (child window) open hoga
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000); // Naya tab khulne ka wait

        // 4. Sabhi open windows/tabs ki IDs get karo

        Set<String> allWindows = driver.getWindowHandles();

        // 5. Naye tab (Child Window) mein switch karo
        for (String windowHandle : allWindows) {
            // Agar ID parent wali nahi hai, matlab wo naya tab hai
            if (!parentWindowId.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // Switch hote hi loop rok do
            }
        }

        // 6. Ab hum naye tab mein hain! Wahan ka text print karte hain
        String newTabText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Naye tab mein text likha hai: " + newTabText);

        // 7. Naya tab close kar do (driver.close() sirf current tab close karta hai)
        driver.close();

        // 8. Wapas Parent tab mein switch karo, warna Selenium confuse ho jayega
        driver.switchTo().window(parentWindowId);

        // Parent tab mein aakar wapas kaam karna shuru karo
        System.out.println("Wapas aane ke baad Parent Tab ka URL: " + driver.getCurrentUrl());

        // Poora browser band karo
        //driver.quit();
    }
}
