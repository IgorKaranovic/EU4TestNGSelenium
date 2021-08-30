package com.cybertek.tests.HomeWork.day8_CheckBox;

import com.cybertek.utilities.WebDriverFactory;
import com.google.common.collect.MultimapBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Checkbox_Verification_1 {

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
        public void Section1() {

        //Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //Locating checkBox element
        WebElement checkBox = driver.findElement(By.id("isAgeSelected"));

        //Locating successMessage element
        WebElement successMessage = driver.findElement(By.id("txtAge"));

        //Verify “Success – Check box is checked” message is NOT displayed.
        Assert.assertFalse(successMessage.isDisplayed(), "Verify message is NOT displayed");

        //Click to checkbox under “Single Checkbox Demo” section
        checkBox.click();

        //Verify “Success – Check box is checked” message is displayed.
        Assert.assertTrue(successMessage.isDisplayed(), "Verify message is displayed");


    }
        @Test
        public void Section2() throws InterruptedException {

            //Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
            driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

            //Locating checkAllButton element
            WebElement checkAllButton = driver.findElement(By.id("check1"));

            //Get button value
            String value = checkAllButton.getAttribute("value");

            //Verify “Check All” button text is “Check All”
            Assert.assertEquals(value,"Check All", "Verify button value is Check All");

            //Click to “Check All” button
            checkAllButton.click();

            //Verify all check boxes are checked

            List<WebElement> options = driver.findElements(By.className("cb1-element"));

            for (WebElement webElement : options) {
                Assert.assertTrue(webElement.isSelected(),"Verify all check boxes are checked");

            }

            //Verify button text changed to “Uncheck All”

            String value1 = checkAllButton.getAttribute("value");

            Thread.sleep(5000);
            Assert.assertEquals(value1,"Uncheck All", "Verify button text changed to Uncheck All");



        }



    }















