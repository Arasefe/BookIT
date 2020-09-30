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


public class UserStory1_AC1 {
    /*
    AC#1 Verify that the user can log in with valid credentials.
    Given I am on BookIt application login page ("https://cybertek-reservation-qa.herokuapp.com/sign-in")
    When I login with valid credentials.(teachervasctoforstall@gmail.com/scottforstall)
    Then I should be able to login to BookIT application
    */
    WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
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
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

}
