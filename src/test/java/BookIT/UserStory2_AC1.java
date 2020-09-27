package BookIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory2_AC1 {
    /*
   As a user I should be able to make a reservation on Book it application using “Hunt” module.
   Acceptance Criteria :
   1. Verify the team lead or a teacher should be able to make a reservation
   2. Verify that authorized user can reserve only one room maximum per day
   3. Verify that authorized user can cancel the reserved room at any time
   4. Verify that during the reservation, authorized users can only book
   the room for future hours, and the system should not allow the User to book a passed time/date.
    */
    WebDriver driver;
    @BeforeClass
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void loginBookIt5() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("scottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedResult = "bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
