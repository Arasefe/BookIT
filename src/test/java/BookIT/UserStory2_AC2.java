package BookIT;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory2_AC2 {
    /*
    AC#2 Verify that authorized user can reserve only one room maximum per day
    Precondition: I should have already one reservation
    Given I am on BookIt application Map page
    When I hit hunt button.
    And I provide the same date of the previous reservation and time
    Then I should not be able to reserve the second room.
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
    public void loginBookIt5() throws InterruptedException {
        WebElement name=driver.findElement(By.xpath("//input[@name='email']"));
        name.sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("scottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        // Find the hunt button and click
        driver.findElement(By.xpath("//a[.='hunt']")).click();
        Thread.sleep(500);
        // Find the date button
        // //div[@class='mat-button-ripple mat-ripple mat-button-ripple-round']
        driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
        Thread.sleep(500);
        // //button[@class='mat-calendar-next-button mat-icon-button']
        driver.findElement(By.xpath("//button[@class='mat-calendar-next-button mat-icon-button']")).click();
        Thread.sleep(500);
        // To enter a day 2 October
        driver.findElement(By.xpath("//div[.='2']")).click();
        Thread.sleep(500);
        // To enter the time from
        driver.findElement(By.xpath("(//span[.='from'])[1]")).click();
        Thread.sleep(500);
        // To enter the time from
        driver.findElement(By.xpath("//span[.=' 11:00am ']")).click();
        Thread.sleep(500);
        // To enter the time to
        driver.findElement(By.xpath("(//span[.='to'])[1]")).click();
        Thread.sleep(500);
        // To enter the time to
        driver.findElement(By.xpath("//span[.=' 12:30am ']")).click();
        Thread.sleep(2000);
        // Search //button[@type='submit']
        driver.findElement(By.xpath("//mat-icon[.='search']")).click();
        Thread.sleep(2000);
        // To book the room
        // (//button[@class='button is-transparent is-white'])[1]
        //(//div[@class='card-footer-item'])[1]
        driver.findElement(By.xpath("(//button[.='book'])[1]")).click();
        Thread.sleep(500);
        // confirmation page
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(500);
        String actualTitle = driver.findElement(By.xpath("//h1[.='yey, you got it']")).getText();
        String expectedResult = "You are not allowed to book twice same day";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
