package BookIT;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory2_AC3 {
    /*
    AC#3 Verify that authorized user can cancel the reserved room at any time
    Given I am on BookIt application Map page
    When I push Schedule button.
    Then I should be able to see the schedule with my reservations
    When I select the already reserved room and hit on the schedule
    Then I should be able to cancel the reservation and see the cancellation message
   */
    WebDriver driver;


    @BeforeMethod
    public void setUpDriver() throws InterruptedException{
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
    }

    @Test
    public void loginCheck() throws InterruptedException{
        WebElement name=driver.findElement(By.xpath("//input[@name='email']"));
        name.sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("scottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        // Find the schedule/my button and click
        driver.findElement(By.xpath("(//a[@class='navbar-link'])[1]")).click();
        Thread.sleep(500);
        // Find  my button and click
        driver.findElement(By.xpath("(//a[.='my'])[1]")).click();
        Thread.sleep(2000);
        // (//td[@class='conference iffy ng-star-inserted'])[1]
        driver.findElement(By.xpath("(//td[@class='conference iffy ng-star-inserted'])[1]")).click();
        Thread.sleep(2000);
        //cancellation  confirmation page
        driver.findElement(By.xpath("//div[.='conference in denali has been canceled']")).click();
        Thread.sleep(2000);
        String actualTitle = driver.findElement(By.xpath("//div[.='conference in denali has been canceled']")).getText();
        String expectedResult = "conference in denali has been canceled";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }


    //
}
