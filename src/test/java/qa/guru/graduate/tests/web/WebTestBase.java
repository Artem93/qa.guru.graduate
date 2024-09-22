package qa.guru.graduate.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.graduate.drivers.ConfigsDriver;
import qa.guru.graduate.enums.LocationEnum;
import qa.guru.graduate.helpers.Attachments;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebTestBase {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://spb.hh.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://spb.hh.ru/";

        if (LocationEnum.valueOf(ConfigsDriver.getSystemConfig().getLocation().toUpperCase()) == LocationEnum.REMOTE) {
            Configuration.browser = System.getProperty("browser", "chrome:100.0").split(":")[0];
            Configuration.browserVersion = System.getProperty("browser", "chrome:100.0").split(":")[1];
            Configuration.remote = System.getProperty("remoteUrl");
        }

        Configuration.browserSize = System.getProperty(
                "resolution",
                "1920x1280");

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
