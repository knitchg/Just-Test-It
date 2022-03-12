import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile {

    WebDriver driver;
    By changePasswordText = By.cssSelector("h4.card-title");

    public Profile(WebDriver driver) {
        this.driver = driver;
    }

    /** Method to check if Change password text is displayed */
    public Boolean isChangePasswordTextDisplayed() {
        return driver.findElement(changePasswordText).isDisplayed();
    }
}
