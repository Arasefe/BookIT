package BookIT;

import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class UserStory4_AC2 {
    /*
    AC#2 Verify that all Users should be able to see reserved rooms made by his/herTeam Lead in "General" section by the Room view schedule.
    Given I am on the "Map" page
    When I click the "Schedule/ General" button
    The I should be able to current week's schedule
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
