import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VoteAndComment extends TestSetup {

    WebDriver driver;
    String alfaGuilaCarUrl = "https://buggy.justtestit.org/model/c4u1mqnarscc72is00ng%7Cc4u1mqnarscc72is00sg"; //Locator of the Guilia car model where you can add vote when logged in
    String userComment = "This is my comment ◘ " + generateRandomNumber();
    By currentNoOfVotes = By.cssSelector("div.card-block > h4 > strong"); //Locator for the current no. of Votes
    By noOfVotesAfterVoting = By.cssSelector("div.card-block > h4 > strong"); //Locator for the No. of Votes after voting
    By voteButton = By.cssSelector("div.card-block > div.btn-block > button.btn.btn-success"); //Locator for the Vote button
    By voteThanks = By.cssSelector("p.card-text"); //Locator for the string "Thank you for your vote" text
    By yourComment = By.cssSelector("label[for='comment']"); //Locator for the string "Your comment"
    By commentField = By.id("comment"); //Locator for the comment field
    By alfaRomeoLogo = By.cssSelector("img[title='Alfa Romeo']"); //Locator for the alfaRomeoLogo
    By allComments = By.cssSelector("p.comment.small"); //Locator for the first comment in the specific car's section
    By alfaGuilaModel = By.cssSelector("a[href=\"/model/c4u1mqnarscc72is00ng|c4u1mqnarscc72is00sg\"]"); //Locator of the Guilia car model under Alfa Romeo list of cars

    public VoteAndComment(WebDriver driver) {
        this.driver = driver;
    }

    /** Method to visit Alfa Romeo Guila Car */
    public void goToAlfaGuilaCar() {
        driver.get(alfaGuilaCarUrl);
        waitForPageLoad();
    }

    /** Method to check current number of votes */
    public Integer checkCurrentNoOfVotes() {
        String numberVotesString =  driver.findElement(currentNoOfVotes).getText();
        System.out.println("---Current no. of Votes: " + numberVotesString + " ---");
        return Integer.parseInt(numberVotesString);
    }

    /** Method to check current number of votes after voting */
    public Integer checkCurrentNoOfVotesAfterVoting() {
        String numberVotesString =  driver.findElement(noOfVotesAfterVoting).getText();
        System.out.println("---No. of Votes after voting: " + numberVotesString + " ---");
        return Integer.parseInt(numberVotesString);
    }

    /** Method to click the Vote button */
    public void clickVoteBtn() {
        driver.findElement(voteButton).click();
    }

    /** Method to check if "Thank you for your vote" is displayed */
    public boolean isThankYouVoteDisplayed() {
        return driver.findElement(voteThanks).isDisplayed();
    }

    /** Method to get the displayed "Thank you for your vote" text */
    public String getThankYouForYourVoteText() {
        return driver.findElement(voteThanks).getText();
    }

    /** Method to check if 'Your comment' is displayed */
    public boolean isYourCommentDisplayed() {
        return driver.findElement(yourComment).isDisplayed();
    }

    /** Method to add Comment */
    public void addComment() {
        driver.findElement(commentField).sendKeys(userComment);
    }

    /** Method to click Alfa Romeo logo */
    public void clickAlfaRomeoLogo() {
        driver.findElement(alfaRomeoLogo).click();
        waitForPageLoad();
    }

    /** Method to check if the added comment is displayed */
    public boolean isTheAddedCommentDisplayed() {
        return driver.findElement(allComments).isDisplayed();
    }

    /** Method to get the displayed comment text */
    public String getDisplayedComment() {
        return driver.findElement(allComments).getText();
    }

    /** Method to click Guilia car link under Alfa Romeo list of cars */
    public void clickGuiliaCarLink() {
        driver.findElement(alfaGuilaModel).click();
    }

}
