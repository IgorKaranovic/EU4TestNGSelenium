package com.cybertek.tests.HomeWork.day10_TestCaseNo_12;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_1 {

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
    public void testCase1(){

        //Step1:Navigate to Url
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        registrationForm.click();

        //Step 3. Enter “wrong_dob” into date of birth input box.
        WebElement birthday = driver.findElement(By.name("birthday"));

        birthday.sendKeys("wrong_dob");

        //Step 4. Verify that warning message is displayed:“The date of birth is not valid”
        WebElement warningMessage = driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));

        Assert.assertTrue(warningMessage.isDisplayed(), "The date of birth is not valid");

    }









}
