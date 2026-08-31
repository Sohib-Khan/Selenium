package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSExecutorExample {
    @Test
    public void Login() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Selenium WebDriver ko JavascriptExecutor mein convert (Typecast) karna
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // ==========================================
        // Use Case 1: JS ke through nayi Website Open karna
        // (driver.get() ka alternative)
        // ==========================================
        Thread.sleep(4000);
        System.out.println("Opening website via JS...");
        js.executeScript("window.location = 'https://demoqa.com/text-box'");
        Thread.sleep(2000);

        // ==========================================
        // Use Case 2: JS ke through Text Enter karna (Set Attribute/Value)
        // (driver.sendKeys() ka alternative)
        // ==========================================
        WebElement nameField = driver.findElement(By.id("userName"));

        // "arguments[0]" ka matlab hai jo element humne pass kiya hai (nameField)
        js.executeScript("arguments[0].value='Sohib Khan';", nameField);
        System.out.println("Text entered using JS");

        // ==========================================
        // Use Case 3: Page ko Scroll karna (Scroll Into View)
        // ==========================================
        // Ek button jo page mein bohot neeche hai, pehle usko find karte hain
        WebElement submitButton = driver.findElement(By.id("submit"));

        // Ab page ko tab tak scroll karenge jab tak ye button screen par na aa jaye
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        System.out.println("Scrolled to Submit button");
        Thread.sleep(4000); // UI update dekhne ke liye thoda wait

        // ==========================================
        // Use Case 4: Element par Click karna
        // (Ye tab use karein jab ElementClickInterceptedException aata hai)
        // ==========================================
        // JS directly DOM level par click karta hai, chahe upar koi ad ya popup hi kyun na ho
        js.executeScript("arguments[0].click();", submitButton);
        System.out.println("Clicked on Submit button using JS");

        // ==========================================
        // Bonus: Page ko top ya bottom tak scroll karna (bina kisi specific element ke)
        // ==========================================
        // Ek dum neeche jana (Scroll to bottom)
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Wapas ek dum upar aana (Scroll to top)
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, 0)");

        // Browser band karna
        Thread.sleep(2000);
        driver.quit();
    }
}
