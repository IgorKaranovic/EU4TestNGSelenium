package com.cybertek.tests.HomeWork.day10_TestCaseNo_12;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_5 {

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
    public void testCase5() throws InterruptedException {

        //Step1:Navigate to Url
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

        registrationForm.click();

        //Step 3. Enter any valid first name.

        WebElement firstName = driver.findElement(By.name("firstname"));

        firstName.sendKeys("Mike");

        //Thread.sleep(2000);

        //Step 4. Enter any valid last name.
        WebElement lastName = driver.findElement(By.name("lastname"));

        lastName.sendKeys("Smith");

        //Thread.sleep(2000);

        //Step 5. Enter any valid user name.
        WebElement userName = driver.findElement(By.name("username"));

        userName.sendKeys("MikeSmith");

        //Thread.sleep(2000);

        //Step 6. Enter any valid password.
        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("mikesmith123");

        //Thread.sleep(2000);

        //Step 7. Enter any valid phone number.
        WebElement phoneNumber = driver.findElement(By.name("phone"));

        phoneNumber.sendKeys("571-571-0000");

        //Thread.sleep(2000);

        //Step 8. Select gender.
        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));

        gender.click();

        //Thread.sleep(2000);

        //Step 9. Enter any valid date of birth.
        WebElement birthday = driver.findElement(By.name("birthday"));

        birthday.sendKeys("11/20/1990");

        //Thread.sleep(2000);

        //Step 10. Select any department.
        WebElement department = driver.findElement(By.name("department"));

        department.click();

        WebElement engineering = driver.findElement(By.xpath("//option[@value='DE']"));

        engineering.click();

        //Thread.sleep(2000);

        //Enter email
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));

        email.sendKeys("mikesmith@gmail.com");

        Thread.sleep(2000);

        //Step 11. Enter any job title.
        WebElement jobTitle = driver.findElement(By.name("department"));

        jobTitle.click();

        WebElement designer = driver.findElement(By.xpath("//option[.='Designer']"));

        designer.click();

        //Thread.sleep(2000);

        //Step 12. Select java as a programming language.
        WebElement language = driver.findElement(By.id("inlineCheckbox1"));

        language.click();

        Thread.sleep(2000);

        //Step 13. Click Sign up.
        WebElement signIn = driver.findElement(By.cssSelector("#wooden_spoon"));

        signIn.click();

        Thread.sleep(3000);

        //Step 14. Verify that following success message is displayed:“You've successfully completed registration!”
        WebElement message = driver.findElement(By.cssSelector("p:nth-child(2)"));

        String actualMessage = message.getText();
        String expectedMessage = "You've successfully completed registration!";

        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
