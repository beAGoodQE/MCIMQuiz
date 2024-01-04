import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TalkToExpertTest {

    public static void main(String[] args) {
        final String homePageUrl = "https://mcim24x7.com/";
        final String talkToExpertTitle = "Talk to An Expert - MCIM";
        final String name = "Test";
        private final String email = "jg@mcim24x7.com";
        final String company = "Test Company";

        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/");

        WebDriver driver = new ChromeDriver();

        // Navigate to the page in test
        driver.get(homePageUrl);

        // Click Talk to an Expert button
        WebElement talkToExpertBtn = driver.findElement(By.xpath("//button[@class="elementor-button-text" and text()="Talk To An Expert"]"));
        talkToExpertBtn.click();

        Assert.assertTrue(driver.getTitle().contains(talkToExpertTitle));

        // Enter First Name, 2 instances of Id form-field-name, so only input 1st in the array
        WebElement firstName = driver.findElement(By.xpath("(//input[@id='form-field-name'])[0]"));
        firstName.sendKeys(name);

        // Enter Last Name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='form-field-field_345ac45']"));
        lastName.sendKeys(name);

        // Enter first instance of Email on the page
        WebElement emaiBox = driver.findElement(By.xpath("(//input[@id='form-field-email'])[0]"));
        emailBox.sendKeys(email);

        // Enter Company Name
        WebElement companyBox = driver.findElement(By.xpath("//input[@id='form-field-field_a1fbb49']"));
        companyBox.sendKeys(company);        

        driver.quit();
    }
}
