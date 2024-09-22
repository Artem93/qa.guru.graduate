package qa.guru.graduate.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static qa.guru.graduate.drivers.ConfigsDriver.getEmulationConfig;
import static qa.guru.graduate.helpers.MobileAppUtils.getAppPath;
import static qa.guru.graduate.helpers.MobileAppUtils.getAppiumServerUrl;

public class EmulationDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options
                .setAutomationName(getEmulationConfig().getUiAutomator())
                .setPlatformName(getEmulationConfig().getPlatform())
                .setPlatformVersion(getEmulationConfig().getOSVersion())
                .setDeviceName(getEmulationConfig().getDevice())
                .setApp(getAppPath())
                .setAppPackage(getEmulationConfig().getAppPackage())
                .setAppActivity(getEmulationConfig().getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }
}
