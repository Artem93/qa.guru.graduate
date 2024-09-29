package qa.guru.graduate.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();
        var bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("userName", ConfigsDriver.getAuthConfig().getLogin());
        bstackOptions.put("accessKey", ConfigsDriver.getAuthConfig().getPassword());
        bstackOptions.put("projectName", ConfigsDriver.getBrowserstackConfig().getProject());
        bstackOptions.put("buildName", ConfigsDriver.getBrowserstackConfig().getBuild());
        caps.setCapability("appium:platformVersion", ConfigsDriver.getBrowserstackConfig().getOSVersion());
        caps.setCapability("appium:deviceName", ConfigsDriver.getBrowserstackConfig().getDevice());
        caps.setCapability("appium:app", ConfigsDriver.getBrowserstackConfig().getApp());
        caps.setCapability("bstack:options", bstackOptions);

        // Initialise the remote AndroidDriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new AndroidDriver(
                    new URL(ConfigsDriver.getBrowserstackConfig().getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}