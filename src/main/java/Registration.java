import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends TestSetup {

    WebDriver driver;
    By userNameRegister = By.name("username"); //Locator for Username in Registration window
    By firstNameRegister = By.name("firstName"); //Locator for First name
    By lastNameRegister = By.name("lastName"); //Locator for Last name
    By passwordRegister = By.id("password"); //Locator for Password
    By confirmPasswordRegister = By.name("confirmPassword"); //Locator for Confirm Password
    By registerBtnRegister = By.cssSelector("button.btn.btn-default"); //Locator for the Register button at the Register page
    By registrationSuccessful = By.cssSelector("div.result.alert.alert-success"); //Locator for Registration successful

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    /** Method to register new user */
    public void registerNewUser() {
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);

        System.out.println("---Registering New user---");
        clickRegisterBtn();
        driver.findElement(userNameRegister).sendKeys(LoginAndLogout.userNameRandom);
        driver.findElement(firstNameRegister).sendKeys(LoginAndLogout.userNameRandom);
        driver.findElement(lastNameRegister).sendKeys("LastName");
        driver.findElement(passwordRegister).sendKeys(LoginAndLogout.password);
        waitForPageLoad();
        driver.findElement(confirmPasswordRegister).sendKeys(LoginAndLogout.password);
        waitForPageLoad();
        driver.findElement(registerBtnRegister).click();
        waitForPageLoad();
        System.out.println("---Registered New user is: " + LoginAndLogout.userNameRandom + "---");
    }

    /** Method to register new user and Login */
    public void registerNewUserAndLogin() {
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);

        //Register User
        System.out.println("---Registering New user---");
        driver.findElement(LoginAndLogout.registerBtn).click();
        driver.findElement(userNameRegister).sendKeys(LoginAndLogout.userNameRandom);
        driver.findElement(firstNameRegister).sendKeys(LoginAndLogout.userNameRandom);
        driver.findElement(lastNameRegister).sendKeys("LastName");
        driver.findElement(passwordRegister).sendKeys(LoginAndLogout.password);
        waitForPageLoad();
        driver.findElement(confirmPasswordRegister).sendKeys(LoginAndLogout.password);
        waitForPageLoad();
        driver.findElement(registerBtnRegister).click();
        waitForPageLoad();
        System.out.println("---Displayed after registering: '" + getTextDisplayedAfterRegister() + "' ---" );
        System.out.println("---Registered New user is: " + LoginAndLogout.userNameRandom + "---");

        //Login New Random User
        driver.get(testPageURL); //Go to test page
        waitForPageLoad();
        LoginAndLogout.typeUsernameRandom();
        LoginAndLogout.typePassword();
        waitForPageLoad();
        LoginAndLogout.clickLogin();
        waitForPageLoad();
        System.out.println("Am I logged in? " + LoginAndLogout.isLogoutDisplayed());
    }

    /** Method to click the Register button */
    public void clickRegisterBtn() {
        LoginAndLogout LoginAndLogout = new LoginAndLogout(driver);
        driver.findElement(LoginAndLogout.registerBtn).click();
    }

    /** Method to check if registration successful is displayed */
    public boolean isRegistrationSuccessfulDisplayed() {
        return driver.findElement(registrationSuccessful).isDisplayed();
    }

    /** Method to get the text displayed after registration */
    public String getTextDisplayedAfterRegister() {
        return driver.findElement(registrationSuccessful).getText();
    }

}
