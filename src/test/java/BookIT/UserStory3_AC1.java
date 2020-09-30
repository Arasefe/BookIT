package BookIT;

import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class UserStory3_AC1 {
    /*
    AC#1 Verify that user can see the room information by clicking a room name on map.
    Given I am on the “Map” page
    When I click the room on the map
    Then I should be able to see the clicked room information


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
