package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FormComponentsPage extends BasePage {
    // Locators for login page elements
    private final By inputField = By.xpath("//*[@resource-id='RNE__Input__text-input']");
    private final By resultField = By.xpath("//android.widget.TextView[@content-desc='input-text-result']");
    private final By switchToggle = By.xpath("//android.widget.Switch[@content-desc='switch']");
    private final By toggleMessage = By.xpath("//android.widget.TextView[@content-desc='switch-text']");
    private final By dropBoxSelector = By.xpath("//android.view.ViewGroup[@content-desc='Dropdown']");
    private final By dropdownList = By.className("android.widget.CheckedTextView");
    private final By dropdownSelectorText = By.xpath("//android.widget.EditText[@resource-id='text_input']");
    private final By activeButton = By.xpath("//android.view.ViewGroup[@content-desc='button-Active']");
    private final By activeSuccessMessage = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");
    private final By askMeLaterButton = By.xpath("//android.widget.Button[@resource-id='android:id/button3']");
    private final By cancelButton = By.xpath("//android.widget.Button[@resource-id='android:id/button2']");
    private final By okButton = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    private final By inactiveButton = By.xpath("//android.view.ViewGroup[@content-desc='button-Inactive']");

    public FormComponentsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendKeysToInputField(String text) {
        waitForElementToBeVisible(inputField, 5);
        enterText(inputField, text);
    }

    public String getTextFromResultField() {
        return getTextFromElement(resultField);
    }

    public void clickOnToggle() {
        clickElement(switchToggle);
    }

    public String getTextFromToggleMessage() {
        return getTextFromElement(toggleMessage);
    }

    public void clickOnDropBoxSelector() {
        clickElement(dropBoxSelector);
    }

    public void chooseOptionByIndex(int index) {
        waitForElementToBeVisible(dropdownList, 5);
        chooseFromListByIndex(dropdownList, index);
    }

    public String getSelectedDropdownListText() {
        return getTextFromElement(dropdownSelectorText);
    }


    public void clickOnActiveButton() {
        clickElement(activeButton);
    }

    public String getActiveSuccessMessage() {
        return getTextFromElement(activeSuccessMessage);
    }

    public boolean checkIfAskMeLaterButtonIsDisplayed() {
        return isDisplayed(askMeLaterButton);
    }

    public boolean checkIfCancelButtonIsDisplayed() {
        return isDisplayed(cancelButton);
    }

    public boolean checkIfOkButtonIsDisplayed() {
        return isDisplayed(okButton);
    }

    public void clickOnOkButton() {
        clickElement(okButton);
    }

    public boolean checkIfTheInactiveButtonIsNotClickable() {
        return isElementClickable(inactiveButton);
    }

}
