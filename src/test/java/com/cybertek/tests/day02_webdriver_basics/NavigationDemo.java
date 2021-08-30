package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromiumdriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //navigate to another website with different selenium method
        driver.navigate().to("https://www.facebook.com");

        //it's comming from Java
        //wait 3 second here and then move on
        Thread.sleep(3000);

        //navigate back to previous page
        driver.navigate().back();

        //goes back to back
        driver.navigate().forward();

        //refresh to webpage
        driver.navigate().refresh();
    }
}
