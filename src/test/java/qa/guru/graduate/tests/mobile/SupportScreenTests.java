package qa.guru.graduate.tests.mobile;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.pages.mobileScreens.FirstScreen;
import qa.guru.graduate.pages.mobileScreens.SupportScreen;

@Tags({
        @Tag("mobile"),
        @Tag("all")
})
@Owner("Артём Лепкин")
@Epic("Мобильные автотесты")
@Feature("Экран тех. поддержки")
@DisplayName("Тесты на проверку экрана тех. поддержки")
public class SupportScreenTests extends MobileTestBase {

    private static final SupportScreen supportScreen = new SupportScreen();
    private static final FirstScreen firstScreen = new FirstScreen();

    @Test
    @DisplayName("Проверка отображения экрана тех. поддержки")
    @AllureId("34663")
    void checkSupportScreenTest() {
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
