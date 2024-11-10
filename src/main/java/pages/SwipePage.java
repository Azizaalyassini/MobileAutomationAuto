package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SwipePage extends BasePage {

    private final By supportVideosCardLocator = By.xpath("//android.widget.TextView[@text='SUPPORT VIDEOS']");

    public SwipePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isSupportVideosCardDisplayed() {
        try {
            return isDisplayed(supportVideosCardLocator);
        } catch (Exception e) {
            return false;
        }
    }

    public void swipeUntilSupportVideosCardIsDisplayed(int maxSwipes) {
        int swipeCount = 0;
        while (swipeCount < maxSwipes) {
            try {
                if (isDisplayed(supportVideosCardLocator)) {
                    System.out.println("Element found after " + swipeCount + " swipes.");
                    break;
                }
            } catch (NoSuchElementException e) {
                swipeRightToLeft(0.9, 0.9, 0.1);
                swipeCount++;
            }

            if (swipeCount == maxSwipes) {
                throw new NoSuchElementException("Element not found after " + maxSwipes + " swipes.");
            }
        }
    }

}
