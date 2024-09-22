package qa.guru.graduate.tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.guru.graduate.drivers.BrowserstackDriver;
import qa.guru.graduate.drivers.EmulationDriver;
import qa.guru.graduate.drivers.RealDriver;
import qa.guru.graduate.enums.TypesMobileHostEnum;
import qa.guru.graduate.helpers.Attachments;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static qa.guru.graduate.drivers.ConfigsDriver.getSystemConfig;
import static qa.guru.graduate.enums.TypesMobileHostEnum.BROWSERSTACK;

public class MobileTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = switch (TypesMobileHostEnum.valueOf(getSystemConfig().getDeviceHost().toUpperCase())) {
            case REAL -> RealDriver.class.getName();
            case EMULATION -> EmulationDriver.class.getName();
            case BROWSERSTACK -> BrowserstackDriver.class.getName();
        };
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        String sessionId = Selenide.sessionId().toString();
        Attachments.attachPage();
        closeWebDriver();

        if (TypesMobileHostEnum.valueOf(getSystemConfig().getDeviceHost().toUpperCase()).equals(BROWSERSTACK)) {
            Attachments.addVideo(sessionId);
        }
    }
}
