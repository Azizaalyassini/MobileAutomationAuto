package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FormComponentsPage;
import pages.Homepage;
import pages.LoginAndSignupPage;
import pages.SwipePage;
import utils.JsonReader;
import utils.RandomUtils;
import utils.TestListener;
import java.util.logging.Logger;
import java.util.HashMap;


@Listeners(TestListener.class)
public class AssignmentTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(AssignmentTest.class.getName());
    private String storedEmail; // Variable to store the email


    @Test(dataProvider = "dataProvider1", dataProviderClass = JsonReader.class)
    public void registerNewUser(HashMap<String, String> hashMap) {
        logger.info("Starting registerNewUser test...");
        Homepage homepage = new Homepage(driver);
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        storedEmail = RandomUtils.generateRandomEmail(); // Generate and store the email
        logger.info("Generated random email: " + storedEmail);

        logger.info("Navigating to the login page.");
        homepage.clickOnloginButton();
        logger.info("Navigating to the signup form.");
        loginAndSignupPage.clickOnSignUpButton();

        logger.info("Filling in the signup form.");
        loginAndSignupPage.sendKeysToEmail(storedEmail);
        loginAndSignupPage.fillTheSignUpForm(hashMap.get("password"), hashMap.get("confirmPassword"));
        Assert.assertTrue(loginAndSignupPage.getTheSignUpSuccessMessage(), "Sign up success message should be displayed.");
        logger.info("Sign up was successful.");

        loginAndSignupPage.clickOnOkayButton();
        logger.info("Logging in with the new user.");
        login(hashMap.get("password"));

        logger.info("Navigating to the form section.");
        homepage.clickOnFormButton();
        fillTheForm(hashMap.get("inputText"), hashMap.get("toggleActiveMessage"), hashMap.get("toggleInactiveMessage"), hashMap.get("firstOptionText"), hashMap.get("secondOptionText"), hashMap.get("thirdOptionText"));

        logger.info("Navigating to the swipe section.");
        homepage.clickOnSwipeButton();
        swipeUntilSupportVideosCard();
        logger.info("Completed registerNewUser test.");
    }

    private void swipeUntilSupportVideosCard() {
        logger.info("Starting swipeUntilSupportVideosCard...");
        SwipePage swipePage = new SwipePage(driver);
        swipePage.swipeUntilSupportVideosCardIsDisplayed(10);
        Assert.assertTrue(swipePage.isSupportVideosCardDisplayed(), "SUPPORT VIDEOS card should be displayed after swiping.");
        logger.info("Swipe test completed successfully.");
    }

    private void fillTheForm(String inputText, String toggleActiveMessage, String toggleInactiveMessage, String firstOptionText, String secondOptionText, String thirdOptionText) {
        logger.info("Filling out the form with provided data.");
        FormComponentsPage formComponentsPage = new FormComponentsPage(driver);
        formComponentsPage.sendKeysToInputField(inputText);
        Assert.assertEquals(formComponentsPage.getTextFromResultField(), inputText, "Input text should match.");
        logger.info("Verified input text.");

        formComponentsPage.clickOnToggle();
        Assert.assertEquals(formComponentsPage.getTextFromToggleMessage(), toggleActiveMessage, "Toggle active message should match.");
        logger.info("Verified toggle active state.");

        formComponentsPage.clickOnToggle();
        Assert.assertEquals(formComponentsPage.getTextFromToggleMessage(), toggleInactiveMessage, "Toggle inactive message should match.");
        logger.info("Verified toggle inactive state.");

        formComponentsPage.clickOnDropBoxSelector();
        formComponentsPage.chooseOptionByIndex(1);
        Assert.assertEquals(formComponentsPage.getSelectedDropdownListText(), firstOptionText, "First dropdown option should match.");
        logger.info("Verified first dropdown selection.");

        formComponentsPage.clickOnDropBoxSelector();
        formComponentsPage.chooseOptionByIndex(2);
        Assert.assertEquals(formComponentsPage.getSelectedDropdownListText(), secondOptionText, "Second dropdown option should match.");
        logger.info("Verified second dropdown selection.");

        formComponentsPage.clickOnDropBoxSelector();
        formComponentsPage.chooseOptionByIndex(3);
        Assert.assertEquals(formComponentsPage.getSelectedDropdownListText(), thirdOptionText, "Third dropdown option should match.");
        logger.info("Verified third dropdown selection.");

        formComponentsPage.clickOnActiveButton();
        Assert.assertTrue(formComponentsPage.checkIfAskMeLaterButtonIsDisplayed(), "'Ask Me Later' button should be displayed.");
        Assert.assertTrue(formComponentsPage.checkIfCancelButtonIsDisplayed(), "Cancel button should be displayed.");
        Assert.assertTrue(formComponentsPage.checkIfOkButtonIsDisplayed(), "OK button should be displayed.");
        Assert.assertFalse(formComponentsPage.checkIfTheInactiveButtonIsNotClickable(), "Inactive button should not be clickable.");
        logger.info("Form interactions verified successfully.");

        formComponentsPage.clickOnOkButton();
        logger.info("Clicked OK button.");
    }

    private void login(String password) {
        logger.info("Starting login process with stored email.");
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.clickOnLoginMainMenuButton();
        loginAndSignupPage.sendKeysToEmail(storedEmail);
        loginAndSignupPage.sendKeysToPassword(password);
        loginAndSignupPage.clickOnLoginButton();
        Assert.assertTrue(loginAndSignupPage.getTheSLoginSuccessMessage(), "Login success message should be displayed.");
        logger.info("Login successful.");
        loginAndSignupPage.clickOnOkayButton();
    }
}
