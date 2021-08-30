package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browser fullscreen

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));

        fullNameInput.sendKeys("Mike Smith");

        //Task
        //Put some email and click Sign up button

        //proper way
//      WebElement emailInput = driver.findElement(By.name("email"));
//
//      emailInput.sendKeys("dadada@dasda.com");

        //lazy way

        driver.findElement(By.name("email")).sendKeys("dadada@dasda.com");


//      WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));

        Thread.sleep(5000);
//      signUpButton.click();

        //lazy way
        driver.findElement(By.name("wooden_spoon")).click();

    }
}
