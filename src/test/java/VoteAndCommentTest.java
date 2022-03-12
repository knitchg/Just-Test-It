import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class VoteAndCommentTest extends TestSetup {

    @Test
    public void checkCanVoteSuccessfully() {
        VoteAndComment voteAndComment = new VoteAndComment(driver);
        Registration registration = new Registration(driver);
        Integer currentNoVotes;
        Integer noVotesAfterVoting;

        registration.registerNewUserAndLogin(); //Register new user & login
        voteAndComment.goToAlfaGuilaCar(); //Go to AlfaGuila car model
        waitForPageLoad();

        //Vote car
        currentNoVotes = voteAndComment.checkCurrentNoOfVotes(); //Check current number of Votes
        voteAndComment.clickVoteBtn(); //Click the Vote button
        waitForPageLoad();

        //Check no. of votes after voting
        voteAndComment.clickAlfaRomeoLogo();
        voteAndComment.clickGuiliaCarLink();
        noVotesAfterVoting = voteAndComment.checkCurrentNoOfVotesAfterVoting();
        Assert.assertTrue(noVotesAfterVoting > currentNoVotes); //Check the number of votes is increased to 1 or greater than before

        //'Thank you for your vote' is displayed with correct text
        Assert.assertTrue(voteAndComment.isThankYouVoteDisplayed());
        Assert.assertTrue(voteAndComment.getThankYouForYourVoteText().contains("Thank you for your vote!"));

    }

    @Test
    public void checkCanCommentSuccessfully() {
        VoteAndComment voteAndComment = new VoteAndComment(driver);
        Registration registration = new Registration(driver);

        registration.registerNewUserAndLogin();
        voteAndComment.goToAlfaGuilaCar(); //Go to AlfaGuila car model
        System.out.println("Can I add comment now? " + voteAndComment.isYourCommentDisplayed());
        voteAndComment.addComment();
        voteAndComment.clickVoteBtn();

        Assert.assertTrue(voteAndComment.isThankYouVoteDisplayed());

        voteAndComment.clickAlfaRomeoLogo();
        System.out.println("Comment displayed: " + voteAndComment.userComment);
        Assert.assertTrue(voteAndComment.isTheAddedCommentDisplayed());
        Assert.assertTrue(voteAndComment.getDisplayedComment().contains(voteAndComment.userComment));
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
