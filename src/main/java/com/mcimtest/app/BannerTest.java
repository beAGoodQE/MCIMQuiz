package com.mcimtest.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

/**
 * Intro Test
 *
 */
public class BannerTest 
{
    public static void main( String[] args )
    {
        final String homePageUrl = "https://mcim24x7.com/";
        final String upsBenchmarkPageTitle = "MCIM Static UPS System Reliability Benchmarking Report";
        final String xpathLearnMore = "//span[@class='elementor-button-text' and text()='Learn more']";

        //Invoke Browser
        // Selenium Manager will be used if this line is commented out below.  Faster to have local
        // System.setProperty("webdriver.chrome.driver", "path/to/");
        WebDriver driver = new ChromeDriver();

        // Navigate to the page in test
        driver.get(homePageUrl);
        driver.manage().window().maximize();
        
        // Verify landed on correct page
        Assert.assertEquals("The Data Center Operating System - MCIM", driver.getTitle());
        Assert.assertEquals("https://mcim24x7.com/", driver.getCurrentUrl());

        // Click Learn More link
        // There are 2 "Learn more" buttons on page, so can't use text.  Suggest adding an ID to buttons
        WebElement linkLearnMore = driver.findElement(By.xpath(xpathLearnMore));
        linkLearnMore.click();

        // Assert UPS Benchmark page title
        Assert.assertTrue(driver.getTitle().contains(upsBenchmarkPageTitle));

        driver.quit();
    }
}
