package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginAndSignupPage extends BasePage {
    // Locators for login page elements
    private By signupMainButton = By.xpath("//android.view.ViewGroup[@content-desc='button-sign-up-container']");
    private By loginMainButton = By.xpath("//android.view.ViewGroup[@content-desc='button-login-container']");
    private By emailField = By.xpath("//android.widget.EditText[@content-desc='input-email']");
    private By passwordField = By.xpath("//android.widget.EditText[@content-desc='input-password']");
    private By confirmPasswordField = By.xpath("//android.widget.EditText[@content-desc='input-repeat-password']");
    private By signUpButton = By.xpath("//android.view.ViewGroup[@content-desc='button-SIGN UP']/android.view.ViewGroup");
    private By signUpSuccessMessage = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");
    private By loginButton = By.xpath("//android.view.ViewGroup[@content-desc='button-LOGIN']/android.view.ViewGroup");
    private By loginSuccessMessage = By.xpath("//android.widget.TextView[@text='You are logged in!']");
    private By popUpOkayButton = By.xpath("//android.widget.Button[@text='OK']");


    public LoginAndSignupPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnSignUpButton() {
        waitForElementToBeVisible(signupMainButton, 5);
        clickElement(signupMainButton);
    }

    public void sendKeysToEmail(String email) {
        enterText(emailField, email);
    }

    public void sendKeysToPassword(String password) {
        enterText(passwordField, password);
    }

    public void sendKeysToConfirmPassword(String confirmPassword) {
        enterText(confirmPasswordField, confirmPassword);
    }

    public void clickOnSignUpButtonInTheSignupForm() {
        clickElement(signUpButton);
    }

    public void fillTheSignUpForm(String password, String confirmPassword) {
        sendKeysToPassword(password);
        sendKeysToConfirmPassword(confirmPassword);
        clickOnSignUpButtonInTheSignupForm();
        waitForElementToBeVisible(signUpSuccessMessage, 5);
    }

    public boolean getTheSignUpSuccessMessage() {
        return isElementPresent(signUpSuccessMessage);
    }

    public void clickOnLoginButton() {
        clickElement(loginButton);
    }

    public boolean getTheSLoginSuccessMessage() {
        return isElementPresent(loginSuccessMessage);
    }

    public void clickOnOkayButton() {
        clickElement(popUpOkayButton);
    }

    public void clickOnLoginMainMenuButton() {
        clickElement(loginMainButton);
    }
}

