package core;
// BasePage.java
// This class serves as a base class for all page classes in the framework.
// It contains common methods and utilities used by the page classes.

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;


public class BasePage {
    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(BasePage.class.getName());


    /**
     * Constructor for the BasePage class.
     * Initializes the driver and sets up the WebDriverWait.
     * @param driver The AppiumDriver instance.
     */
    public BasePage(AppiumDriver<MobileElement> driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver instance cannot be null");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    /**
     * Waits for an element to be visible on the page.
     * @param locator The locator of the element.
     * @param timeoutInSeconds The maximum time to wait for the element.
     */
    public void waitForElementToBeVisible(By locator, long timeoutInSeconds) {
        logger.info("wait for element to be visable");
        WebDriverWait customWait = new WebDriverWait(driver, timeoutInSeconds);
        customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Checks if an element is present on the page.
     * @param locator The locator of the element.
     * @return true if the element is present, false otherwise.
     */
    public boolean isElementPresent(By locator) {
        try {
            waitForElementToBeVisible(locator, 5);
            MobileElement element = (MobileElement) driver.findElement(locator);
            return element != null; // Element found
        } catch (NoSuchElementException e) {
            return false; // Element not found
        }
    }

    /**
     * Chooses an element from a list identified by a locator and clicks it by index.
     * @param locator The locator of the list elements.
     * @param index The index of the element to click.
     */
    public void chooseFromListByIndex(By locator, int index) {
        List<MobileElement> elements = driver.findElements(locator);
        if (index >= 0 && index < elements.size()) {
            elements.get(index).click(); // Clicks on the element at the given index
        } else {
            throw new IndexOutOfBoundsException("Invalid index provided for the dropdown list.");
        }
    }

    /**
     * Retrieves the text of an element from a list by index.
     * @param locator The locator of the list elements.
     * @param index The index of the element.
     * @return The text of the element.
     */
    public String getTextFromListElementByIndex(By locator, int index) {
        List<MobileElement> elements = driver.findElements(locator).stream()
                .map(element -> (MobileElement) element)
                .collect(Collectors.toList());

        if (index >= 0 && index < elements.size()) {
            return elements.get(index).getText(); // Returns the text of the element at the given index
        } else {
            throw new IndexOutOfBoundsException("Invalid index provided for the dropdown list.");
        }
    }

    /**
     * Retrieves the text from an element.
     * @param locator The locator of the element.
     * @return The text of the element, or null if an error occurs.
     */
    public String getTextFromElement(By locator) {
        try {
            MobileElement element = (MobileElement) driver.findElement(locator);
            return element.getText();
        } catch (Exception e) {
            System.err.println("Failed to get text from element: " + e.getMessage());
            return null; // or handle as needed
        }
    }

    /**
     * Checks if an element is displayed on the page.
     * @param locator The locator of the element.
     * @return true if the element is displayed, false otherwise.
     */
    public boolean isDisplayed(By locator) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    /**
     * Checks if an element is clickable.
     * @param locator The locator of the element.
     * @return true if the element is clickable, false otherwise.
     */
    public boolean isElementClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust timeout as needed
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true; // The element is clickable
        } catch (Exception e) {
            return false; // The element is not clickable
        }
    }

    /**
     * Clicks on an element located by the provided locator.
     * @param locator The locator of the element to be clicked.
     */
    public void clickElement(By locator) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Enters text into an input field located by the provided locator.
     * @param locator The locator of the input field.
     * @param text The text to be entered.
     */
    public void enterText(By locator, String text) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /**
     * Retrieves the width of the device screen.
     * @return The width of the device screen.
     */
    public int getDeviceWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    /**
     * Retrieves the height of the device screen.
     * @return The height of the device screen.
     */
    public int getDeviceHeight() {
        return driver.manage().window().getSize().getHeight();
    }

    /**
     * Performs a swipe action from right to left on the screen.
     * @param verticalPositionPercent The vertical position as a percentage of the screen height.
     * @param startXPercent The start X position as a percentage of the screen width.
     * @param endXPercent The end X position as a percentage of the screen width.
     */
    public void swipeRightToLeft(double verticalPositionPercent, double startXPercent, double endXPercent) {
        int screenHeight = getDeviceHeight();
        int screenWidth = getDeviceWidth();

        // Calculate Y position for the swipe at the specified vertical position percentage
        int yPosition = (int) (screenHeight * verticalPositionPercent);

        // Calculate the start and end X positions for the swipe
        int startX = (int) (screenWidth * startXPercent);
        int endX = (int) (screenWidth * endXPercent);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, yPosition));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(600)));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, yPosition));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
}
