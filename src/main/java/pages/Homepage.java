package pages;
// Homepage.java
// This class represents the homepage of the application.
// It extends BasePage to inherit common properties and methods.

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Homepage extends BasePage {
    // Locators for login page elements
    private By loginButton = By.xpath("//android.view.View[@content-desc='Login']");
    private By formButton = By.xpath("//android.view.View[@content-desc='Forms']");
    private By swapButton = By.xpath("//android.view.View[@content-desc='Swipe']");

    /**
     * Constructor for Homepage.
     * Initializes the driver for the homepage.
     * @param driver The AppiumDriver instance.
     */
    public Homepage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on the login button to navigate to the login page.
     */
    public void clickOnloginButton() {
        waitForElementToBeVisible(loginButton, 5);
        clickElement(loginButton);
    }

    public void clickOnFormButton() {
        waitForElementToBeVisible(formButton, 5);
        clickElement(formButton);
    }

    public void clickOnSwipeButton() {
        waitForElementToBeVisible(swapButton, 5);
        clickElement(swapButton);
    }

}
