package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "15.0");
            caps.setCapability("deviceName", "Medium Phone API 35");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", "/Users/qa-safeer/Downloads/android.wdio.native.app.v1.0.8.apk");

            driver = new AndroidDriver<>(new URL("http://localhost:4723/"), caps);
            System.out.println("Driver initialized successfully.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Appium server URL is incorrect");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
