import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTest extends TestSetup{

    @Test
    public void checkSuccessfulRegistration() {
        Registration Registration = new Registration(driver);
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);

        //Register new user
        Registration.registerNewUser();
        Assert.assertTrue(Registration.isRegistrationSuccessfulDisplayed());
        Assert.assertTrue(Registration.getTextDisplayedAfterRegister().contains("Registration is successful"));

    }

    @Before
    public void setup() {
        beforeWithoutLoggingIn(testPageURL);
    }

    @After
    public void tearDown() {
        after();
    }
}
