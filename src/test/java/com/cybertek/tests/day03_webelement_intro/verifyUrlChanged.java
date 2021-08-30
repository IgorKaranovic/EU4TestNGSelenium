package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) {

        /* Verify URL changed
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
        */

        // open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys("dadada@dadada.com");

        //click retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //Task
        //verify that Url changed to http://practice.cybertekschool.com/email_sent
        retrievePasswordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        //saving actual Url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);

        }

        //close the browser
        driver.quit();

    }
}
