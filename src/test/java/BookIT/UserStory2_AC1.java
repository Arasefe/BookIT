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

public class UserStory2_AC1 {

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
        /*
        AC#1 Verify the team lead or a teacher should be able to make a reservation
        Given I am on BookIt application Map page
        When I hit "hunt" button.
        And I provide date and time
        And I hit search button
        Then I should be able to see available rooms
        When I select the preferred room and hit "book button"
        And I hit next "confirm" button
        Then I should be able to reserve and see the confirmation message
        */
        WebElement name=driver.findElement(By.xpath("//input[@name='email']"));
        name.sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("scottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[.='hunt']")).click();
        Thread.sleep(500);
        //
        driver.findElement(By.xpath("//div[.='28']")).click();
        Thread.sleep(500);
        //
        driver.findElement(By.xpath("//span[.='from']")).click();
        Thread.sleep(500);
        //
        driver.findElement(By.xpath("//span[.=' 7:00am ']")).click();
        Thread.sleep(500);
        //
        driver.findElement(By.xpath("//span[.=' 8:00am ']")).click();
        Thread.sleep(500);
        //
        driver.findElement(By.xpath("//mat-icon[.='search']")).click();
        Thread.sleep(500);
        //
        driver.findElement(By.xpath("//*[.='book'])[3]")).click();
        Thread.sleep(500);
        // confirmation page
        driver.findElement(By.xpath("//button[.='confirm']")).click();
        Thread.sleep(500);
        String actualTitle = driver.findElement(By.xpath("//h1[.='yey, you got it']")).getText();
        String expectedResult = "yey, you got it";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
