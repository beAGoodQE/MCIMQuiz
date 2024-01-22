package com.mcimtest.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Click on Talk to An Expert 
 * Fill out the form with the name Test Test, my email - jg@mcim24x7.com, and any company and submit 
 *
 */
public class TalkToExpertTest 
{
    public static void main( String[] args )
    {
        final String homePageUrl = "https://mcim24x7.com/";
        final String xpathTalkExpert = "//span[@class='elementor-button-text' and text()='Talk To An Expert']";
        final String xpathFirstName = "(//input[@id='form-field-name'])[1]";
        final String idCompany = "form-field-field_a1fbb49";
        final String idLastName = "form-field-field_345ac45";
        final String xpathEmail = "(//input[@id='form-field-email'])[1]";
        final String xpathSend = "(//span[@class='elementor-button-text' and text()='Send'])[1]";

        final String talkToExpertTitle = "Talk To An Expert - MCIM";
        final String name = "Test";
        final String email = "jg@mcim24x7.com";
        final String company = "Test Company";

        //Invoke Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the page in test
        driver.get(homePageUrl);
        driver.manage().window().maximize();

        // Verify landed on correct page
        Assert.assertEquals("The Data Center Operating System - MCIM", driver.getTitle());
        Assert.assertEquals("https://mcim24x7.com/", driver.getCurrentUrl());
        
        // Click Talk to an Expert button
        WebElement talkToExpertBtn = driver.findElement(By.xpath(xpathTalkExpert));
        talkToExpertBtn.click();

        // Assert UPS Benchmark page title
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(talkToExpertTitle));

        // Enter First Name, 2 instances of Id form-field-name, so only input 1st in the array
        WebElement firstName = driver.findElement(By.xpath(xpathFirstName));
        firstName.sendKeys(name);
        
        // Enter Last Name
        // Odd ID, suggest to update to form-last-name
        WebElement lastName = driver.findElement(By.id(idLastName));
        lastName.sendKeys(name);        


        // Enter first instance of Email on the page
        WebElement emailBox = driver.findElement(By.xpath(xpathEmail));
        emailBox.sendKeys(email);

        // Enter Company Name
        WebElement companyBox = driver.findElement(By.id(idCompany));
        companyBox.sendKeys(company);

        // Click Send
        WebElement sendButton = driver.findElement(By.xpath(xpathSend));
//        sendButton.click();
        sleepy();

        driver.quit();
    }

    public static void sleepy() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
