package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class InitAppiumDriver {

    public static WebDriverWait webDriverWait;
    public static AppiumDriver<MobileElement> appiumDriver;

    public static void init() throws Exception {
        appiumDriver = null;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PAGE_LOAD_STRATEGY, "eager");
        capabilities.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/app/sauce-labs.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");

        if (appiumDriver == null) {
            try {
                appiumDriver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                System.out.println("App is started successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw e;
            }
        } else {
            throw new Exception("Driver is null, abort task.");
        }

        webDriverWait = new WebDriverWait(appiumDriver, 15);
    }

    public static void quit() {
        appiumDriver.quit();
    }
}