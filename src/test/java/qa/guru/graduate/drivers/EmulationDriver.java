package qa.guru.graduate.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static qa.guru.graduate.helpers.MobileAppUtils.getAppPath;
import static qa.guru.graduate.helpers.MobileAppUtils.getAppiumServerUrl;

public class EmulationDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options
                .setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(ConfigsDriver.getEmulationConfig().getOSVersion())
                .setDeviceName(ConfigsDriver.getEmulationConfig().getDevice())
                .setApp(getAppPath())
                .setAppPackage(ConfigsDriver.getEmulationConfig().getAppPackage())
                .setAppActivity(ConfigsDriver.getEmulationConfig().getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }
}
