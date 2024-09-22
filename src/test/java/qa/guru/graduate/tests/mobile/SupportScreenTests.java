package qa.guru.graduate.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.pages.mobileScreens.FirstScreen;
import qa.guru.graduate.pages.mobileScreens.SupportScreen;

public class SupportScreenTests extends MobileTestBase {
    private static final SupportScreen supportScreen = new SupportScreen();
    private static final FirstScreen firstScreen = new FirstScreen();

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("all")
    })
    @DisplayName("Проверка отображения экрана саппорта")
    void checkSupportScreen() {
        firstScreen
                .clickSupportButton();
        supportScreen
                .checkHeaderTitleText()
                .checkHeaderSubtitleText()
                .checkMoreButtonVisible()
                .checkBotMessageText()
                .checkAttachFileButtonVisible()
                .checkTextInputVisible()
                .checkSendButtonVisible();
    }
}
