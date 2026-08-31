package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Screenshot {

    @Test
    public void test_js() throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://aijobfit.artifactgeeks.com/");
      TakesScreenshot takesScreenshot  = (TakesScreenshot) driver;
        File src =takesScreenshot.getScreenshotAs(OutputType.FILE);


        try {
            FileHandler.copy(src,new File("C:\\Users\\abc\\OneDrive\\Documents\\Custom Office Templates"));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }



    }
}
