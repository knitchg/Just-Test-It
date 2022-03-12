import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class TestSetup {

    public static WebDriver driver;
    public String testPageURL = "https://buggy.justtestit.org/";

    public void beforeWithoutLoggingIn(String testPageURL) {
        System.out.println("-------------Initializing the driver.-------------------");
        driver = DriverFactory.open("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(testPageURL);
    }

    public void beforeWithLoginAsRandomNewUser(String testPageURL) {
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);

        System.out.println("-------------Initializing the driver.-------------------");
        driver = DriverFactory.open("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(testPageURL);

        LoginAndLogout.loginToBuggyCarsAsNewUser();
        waitForPageLoad();
    }

    public void after() {
        System.out.println("-------------Closing the driver-------------------");
        driver.manage().deleteAllCookies();
        driver.close();
    }

    /** Method to generate random number String */
    public String generateRandomNumber(){
        int randomInt = 0;

        Random rd = new Random();
        for (int idx = 1000; idx <= 1000000; ++idx) {
            randomInt = rd.nextInt(1000000);
        }
        String randomNumberString = Integer.toString(randomInt);
        return randomNumberString;
    }


    public void waitForPageLoad() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
