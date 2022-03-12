import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class LoginAndLogout extends TestSetup {

    WebDriver driver;
    String userName = "TestUserName"; //-- Todo: to be linked to a feature file excluded in GIT
    String userNameRandom = "TestUserName" + generateRandomNumber();
    String password = "Password@123"; //-- Todo: to be linked to a feature file excluded in GIT
    String wrongPassword = "asdf!7!7";
    By loginBtn = By.cssSelector("button.btn.btn-success"); // Locator for login button
    By logoutBtn = By.cssSelector("a[href=\"javascript:void(0)\"]"); // Locator for logout button
    By userNameInput = By.name("login"); //Locator for Username field
    By passwordInput = By.name("password"); //Locator for Password field
    By userNameDisplayed = By.cssSelector("span.nav-link.disabled"); //Locator for User Name
    By profileLink = By.linkText("Profile"); //Locator for the Profile link
    By registerBtn = By.cssSelector("a.btn.btn-success-outline"); //Locator for the Register button
    By invalidLogin = By.cssSelector("span.label.label-warning"); //Locator for Invlid username/password when logging in


    public LoginAndLogout(WebDriver driver) {
        this.driver = driver;
    }

    /** Method to login */
    public void loginToBuggyCars() {
        System.out.println("---Logging in---");
        typeUsername();
        typePassword();
        clickLogin();
    }

    /** Method to login as a New user */
    public void loginToBuggyCarsAsNewUser() {
        Registration Registration = new Registration(driver);

        System.out.println("---Logging in---");
        Registration.registerNewUserAndLogin();
    }

    /** Method to click the login button */
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    /** Method to click the logout button */
    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }

    /** Method to input Username */
    public void typeUsername() {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    /** Method to input Newly created Username */
    public void typeUsernameRandom() {
        driver.findElement(userNameInput).sendKeys(userNameRandom);
    }

    /** Method to input Password */
    public void typePassword() {
        driver.findElement(passwordInput).sendKeys(password);
    }

    /** Method to input wrong Password */
    public void typeWrongPassword() {
        driver.findElement(passwordInput).sendKeys(wrongPassword);
    }

    /** Method to get the User's first name */
    public String getUserName() {
        return driver.findElement(userNameDisplayed).getText();
    }

    /** Method to get the Profile text */
    public String getProfileLink() {
        return driver.findElement(profileLink).getText();
    }

    /** Method to check if the Profile text is displayed */
    public Boolean isProfileTextDisplayed() {
        return driver.findElement(userNameDisplayed).isDisplayed();
    }

    /** Method to check if the Logout button is displayed */
    public Boolean isLogoutDisplayed() {
        return driver.findElement(logoutBtn).isDisplayed();
    }

    /** Method to check if the Register button is displayed */
    public Boolean isRegisterBtnDisplayed() {
        return driver.findElement(registerBtn).isDisplayed();
    }

    /** Method to check if the Login button is displayed */
    public Boolean isLoginBtnDisplayed() {
        return driver.findElement(loginBtn).isDisplayed();
    }

    /** Method to click the Profile button */
    public void clickProfileBtn() {
        driver.findElement(profileLink).click();
    }

    /** Method to check if invalid username/password is displayed */
    public boolean isInvalidUsernamePasswordDisplayed() {
        return driver.findElement(invalidLogin).isDisplayed();
    }

    /** Method to check the displayed invalid username/password text */
    public String checkInvalidLoginText() {
        return driver.findElement(invalidLogin).getText();
    }
}
