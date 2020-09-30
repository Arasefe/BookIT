package BookIT;

import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class UserStory2_AC4 {
    /*
   AC#4 Verify that during the reservation, authorized users can only book the room for future hours, and the system should not allow the User to book a passed time/date.
    Given I am on BookIt application Map page
    When I push "Hunt" button.
    Then I should be able to see "Hunt for Spot" page
    When I try to select passed date and time
    Then I should NOT be able to make a reservation
    */

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver() throws InterruptedException{
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }
}
