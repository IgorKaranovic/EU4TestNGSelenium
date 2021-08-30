package com.cybertek.tests.day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestCase2 {

    /*Test case 2
    Go to Ebay
    search Selenium
    click on search button
    verify title contains Selenium
     */

    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to ebay website
        driver.get("https://www.ebay.com/");

        //finding unique locator (By ID) for searchBox and storing it as a WebElement
        WebElement searchBox = driver.findElement(By.id("gh-ac"));

        //finding unique locator (By XPath) for searchBox and storing it as a WebElement
        //WebElement searchBox1 = driver.findElement(By.xpath("//input[@*='gh-ac']"));

        //storing Selenium value as expectedResult
        String keyword = "Selenium";

        //typing "Selenium" into searchBox
        searchBox.sendKeys(keyword);

        //finding unique locator (By Xpath) for searchButton and storing it as a WebElement
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));

        //Click the button
        searchButton.click();

        //using getTitle() to retrieve Title and storing it as variable
        String actualResult = driver.getTitle();

        //print if actualResult contains expectedResult
        System.out.println(driver.getTitle().contains(keyword));

        //call a method that we compare actualResult and expectedResult
        verifyContains(keyword,actualResult);


        Thread.sleep(2000);

        //close the browser
        driver.quit();

    }

    public static void verifyContains(String expectedResult, String actualResult){

        if(actualResult.contains(expectedResult)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected = " + expectedResult);
            System.out.println("actual = " + actualResult);
        }
    }


}
