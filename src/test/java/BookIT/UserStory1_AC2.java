package BookIT;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory1_AC2 {
    /*
    AC#2 Verify that the user NOT able to log in with invalid credentials.
    Given I am on BookIt application login page ("https://cybertek-reservation-qa.herokuapp.com/sign-in")
    When I login with invalid credentials.
    Then I should not be able to login to BookIT application and see the error message “ [objectProgressEvent] ”.
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
    public void loginBookIt1() throws InterruptedException {
        WebElement name=driver.findElement(By.xpath("//input[@name='email']"));
        name.sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("cottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle=driver.findElement(By.xpath("//div[.='[object ProgressEvent]']")).getText();
        String expectedResult="[object ProgressEvent]";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
