package com.cybertek.tests.HomeWork.day10_TestCaseNo_12;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void testCase4(){

        //Step1:Navigate to Url
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        registrationForm.click();

        //Step 3. Enter only one alphabetic character into last name input box.

        WebElement lastName = driver.findElement(By.name("lastname"));

        lastName.sendKeys("a");

        WebElement message = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));

        String actualText = message.getText();

        String expectedText = "The last name must be more than 2 and less than 64 characters long";

        //Step 4. Verify that warning message is displayed:
        // “The last name must be more than 2 and less than 64 characters long”
        Assert.assertEquals(actualText,expectedText);

    }
}

