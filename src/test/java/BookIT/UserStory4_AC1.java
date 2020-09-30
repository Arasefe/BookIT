package BookIT;

import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class UserStory4_AC1 {
    /*
    AC#1 Verify that all users should be able to see reserved rooms made by his/herTeam Lead in "My" section by the current Week's view schedule.
    Given I am on the "Map" page
    When I click the schedule/ my button
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
