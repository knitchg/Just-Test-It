import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginAndLogoutTest extends TestSetup {


    @Test
    public void checkSuccessfulLogin() {
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);
        System.out.println("---Logging in---");
        LoginAndLogout.loginToBuggyCars();
        waitForPageLoad();

        //Check for successful login
        Assert.assertEquals(LoginAndLogout.getUserName(),"Hi, First Name");
        Assert.assertEquals(LoginAndLogout.getProfileLink(),"Profile");
        Assert.assertTrue(LoginAndLogout.isProfileTextDisplayed());
        Assert.assertTrue(LoginAndLogout.isLogoutDisplayed());
    }

    @Test
    public void checkInvalidLogin() {
        LoginAndLogout loginAndLogout = new LoginAndLogout(driver);

        System.out.println("---Login as Invalid User---");
        loginAndLogout.typeUsername();
        loginAndLogout.typeWrongPassword(); //Input wrong password
        loginAndLogout.clickLogin();
        waitForPageLoad();

        //Check that login is not successful
        Assert.assertTrue(loginAndLogout.isInvalidUsernamePasswordDisplayed());
        Assert.assertEquals(loginAndLogout.checkInvalidLoginText(), "Invalid username/password");
        Assert.assertTrue(loginAndLogout.isLoginBtnDisplayed());
    }

    @Test
    public void checkSuccessfulLogout() {
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);
        Profile Profile = new Profile(driver);

        //Logout to Buggy Cars
        LoginAndLogout.loginToBuggyCars();
        waitForPageLoad();
        LoginAndLogout.clickProfileBtn(); //Display profile before logging out to check that sensitive info is not displayed after successful logout
        LoginAndLogout.clickLogout();

        //Check if Logout is successful
        Assert.assertTrue(LoginAndLogout.isRegisterBtnDisplayed());
        Assert.assertTrue(LoginAndLogout.isLoginBtnDisplayed());
        System.out.println("---Check that the screen doesn't display sensitive info anymore after logout---");
        Assert.assertFalse(Profile.isChangePasswordTextDisplayed()); //Note: This part currently fails - MAJOR BUG raised
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
