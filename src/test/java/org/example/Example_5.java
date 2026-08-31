package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example_5 {
    @Test
    public void login() throws InterruptedException {
        // Driver setup
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // 1. Website open karo
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000); // Wait for page load (Real project mein Explicit wait use karein)

        // 2. Iframe ke andar switch karo (id ka use karke)
        // Yahan editor ka iframe id "mce_0_ifr" hai
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(2000);
        // 3. Iframe ke andar ka element (Text box) find karo
        WebElement textBox = driver.findElement(By.id("tinymce"));

        // Purana text clear karo aur naya likho
        textBox.clear();
        textBox.sendKeys("Hello Sohib! Yeh text Iframe ke andar likha gaya hai.");
        Thread.sleep(2000);

        // 4. SABSE IMPORTANT: Iframe se bahar main page par wapas aao
        driver.switchTo().defaultContent();

        // 5. Main page ka element dhoondho aur verify karo ki hum bahar aa chuke hain
        WebElement pageTitle = driver.findElement(By.xpath("//h3"));
        System.out.println("Main page ka title hai: " + pageTitle.getText());

        driver.quit();
    }
}
