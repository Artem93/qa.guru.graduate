package qa.guru.graduate.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", ConfigsDriver.getAuthConfig().getLogin());
        caps.setCapability("browserstack.key", ConfigsDriver.getAuthConfig().getPassword());

        // Set URL of the application under test
        caps.setCapability("app", ConfigsDriver.getBrowserstackConfig().getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", ConfigsDriver.getBrowserstackConfig().getDevice());
        caps.setCapability("os_version", ConfigsDriver.getBrowserstackConfig().getOSVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", ConfigsDriver.getBrowserstackConfig().getProject());
        caps.setCapability("build", ConfigsDriver.getBrowserstackConfig().getBuild());
        caps.setCapability("name", ConfigsDriver.getBrowserstackConfig().getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(ConfigsDriver.getBrowserstackConfig().getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}