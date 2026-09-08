package org.example;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Example_2 {

    @Test
    public void Linktext() throws InterruptedException, AWTException {

        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_O);


    }
}
