package org.example;

import org.testng.annotations.Test;

public class Test9 {
//    @Test
//    public void validLoginTest() {
//        System.out.println("Valid login test executed");
//    }
//
//    @Test
//    public void invalidLoginTest() {
//        System.out.println("Invalid login test executed");


        @Test
        public void loginTest() throws InterruptedException {
            System.out.println("Login Test Started - "
                    + Thread.currentThread().getId());

            Thread.sleep(3000);

            System.out.println("Login Test Finished");
        }
    }




