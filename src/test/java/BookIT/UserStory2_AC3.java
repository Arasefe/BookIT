package BookIT;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void loginCheck(){
        System.out.println("TestNG is working");
    }

}
