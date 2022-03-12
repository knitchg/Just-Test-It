import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    /** This method returns a WebDriver object */
    public static WebDriver open(String browserType) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KnitchelG\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        return new ChromeDriver();
    }
}
