package com.cybertek.tests.HomeWork.day10_TestCaseNo_12;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_2 {

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
    public void testCase2(){

        //Step1:Navigate to Url
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        registrationForm.click();

        //Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
        List<WebElement> languages = driver.findElements(By.className("form-check-label"));

        for (WebElement language : languages) {

            Assert.assertTrue(language.isDisplayed());
        }
    }
}
