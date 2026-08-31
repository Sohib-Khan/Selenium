package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertj {

    @Test
    public void loginTest() {

        String actualTitle = "Dashboard";
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Login validation successful");
    }
}
