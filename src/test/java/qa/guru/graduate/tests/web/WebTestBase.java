package qa.guru.graduate.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.graduate.drivers.ConfigsDriver;
import qa.guru.graduate.helpers.Attachments;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://spb.hh.ru/";

        var browser = ConfigsDriver.getWebConfig().getBrowser();
        if (browser.contains(":")) {
            Configuration.browser = browser.split(":")[0];
            Configuration.browserVersion = browser.split(":")[1];
        } else {
            Configuration.browser = browser;
            Configuration.browserVersion = ConfigsDriver.getWebConfig().getBrowserVersion();
        }
        if (ConfigsDriver.getWebConfig().getRemoteUrl() != null) {
            Configuration.remote = ConfigsDriver.getWebConfig().getRemoteUrl();
        }

        Configuration.browserSize = ConfigsDriver.getWebConfig().getResolution();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attachments.attachPage();
        Attachments.attachScreenshot();
        Attachments.addVideo();
        closeWebDriver();
    }
}
