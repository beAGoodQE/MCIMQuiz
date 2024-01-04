import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BannerTest {

    public static void main(String[] args) {
        final String homePageUrl = "https://mcim24x7.com/";
        final String upsBenchmarkPageTitle = "MCIM Static UPS System Reliability Benchmarking Report";

        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/");

        WebDriver driver = new ChromeDriver();

        // Navigate to the page in test
        driver.get(homePageUrl);

        // Click Learn More link
        WebElement linkLearnMore = driver.findElement(By.xpath("//a[text()='Learn more']"));
        linkLearnMore.click();

        // Assert UPS Benchmark page title
        Assert.assertTrue(driver.getTitle().contains(upsBenchmarkPageTitle));

        driver.quit();
    }
}
