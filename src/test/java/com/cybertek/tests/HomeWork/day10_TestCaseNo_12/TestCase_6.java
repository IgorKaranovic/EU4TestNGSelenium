package com.cybertek.tests.HomeWork.day10_TestCaseNo_12;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_6 {

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
    public void testCase6() throws InterruptedException {

        //Step1:Navigate to Url
        driver.get("https://www.tempmailaddress.com/");

        //Step 2. Copy and save email as a string.
        WebElement findEmail = driver.findElement(By.id("email"));

        String email = findEmail.getText();

        //Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 4. And click on “Sign Up For Mailing List".

        WebElement signUp = driver.findElement(By.xpath("//a[@href='/sign_up']"));

        signUp.click();

        //Step 5. Enter any valid name.
        WebElement fullName = driver.findElement(By.name("full_name"));

        fullName.sendKeys("MikeSmith");

        //Step 6. Enter email from the Step 2.
        WebElement email1 = driver.findElement(By.name("email"));

        email1.sendKeys(email);

        //Thread.sleep(5000);

        //Step 7. Click Sign Up
        WebElement signIn = driver.findElement(By.name("wooden_spoon"));

        signIn.click();

        //Step 8. Verify that following message is displayed:
        // “Thank you for signing up. Click the button below to return to the home page.”

        WebElement messageIsDysplayed = driver.findElement(By.name("signup_message"));

        messageIsDysplayed.isDisplayed();
        Thread.sleep(5000);
        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”

        driver.navigate().to("https://www.tempmailaddress.com/");

        Thread.sleep(5000);
        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”

        WebElement receivedEmail = driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]"));

        receivedEmail.isDisplayed();

        Thread.sleep(2000);

        WebElement newEmail = driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]/td[1]"));

        String actualResult = newEmail.getText();

        String expectedResult = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actualResult.trim(),expectedResult);

        //Step 11. Click on that email to open it.
        newEmail.click();
        Thread.sleep(5000);

        //Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”

        WebElement emailHeader = driver.findElement(By.id("odesilatel"));

        String emailAddress = emailHeader.getText();
        String expextedEmail = expectedResult;

        Assert.assertEquals(emailAddress,expextedEmail);

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”

        WebElement subject = driver.findElement(By.id("predmet"));

        String actualResultFinal = subject.getText();
        String expectedResultFinal = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actualResultFinal,expectedResultFinal,"Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!");

    }
}
