package com.mcimtest.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the most common word on our homepage. Ignore “of”, “the”, “and”, “a”, “an” and other articles.
 * 
 * Assumption!  Only single words count, i.e. 'MCIM' itself counts, but 'support@mcim24x7.com' does not.
 */
public class PopularWordsTest {
    public static void main( String[] args )
    {    
        final String homePageUrl = "https://mcim24x7.com/";
        String pageText;
        List<String> ignoreWords = Arrays.asList("of", "the", "and", "a", "an");

        //Invoke Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the page in test
        driver.get(homePageUrl);
        driver.manage().window().maximize();

        // Verify landed on correct page
        Assert.assertEquals("The Data Center Operating System - MCIM", driver.getTitle());
        Assert.assertEquals("https://mcim24x7.com/", driver.getCurrentUrl());

        // Get text on page
        WebElement pageTextElement = driver.findElement(By.tagName("body"));
        String[] pageWords = pageTextElement.getText().toLowerCase().split("\\s+");

        // Create a map to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        driver.quit();

        for (String pageWord : pageWords) {
            if (!ignoreWords.contains(pageWord)) {
                wordCounts.put(pageWord, wordCounts.getOrDefault(pageWord, 0) + 1);
            }
        }

        String mostCommonWord = findMostCommonWord(wordCounts);
        System.out.println("The most common word (excluding ignored words) is: " + mostCommonWord);
        Assert.assertEquals("to", mostCommonWord);
    }
    
    private static String findMostCommonWord(Map<String, Integer> wordCounts) {
        String mostCommonWord = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommonWord;
    }
}
