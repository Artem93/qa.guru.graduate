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

@Tags({
        @Tag("mobile"),
        @Tag("all")
})
@Owner("Артём Лепкин")
@Epic("Мобильные автотесты")
@Feature("Стартовый экран")
@DisplayName("Тесты на проверку стартового экрана")
public class FirstScreenTests extends MobileTestBase {

    private static final FirstScreen firstScreen = new FirstScreen();

    @Test
    @DisplayName("Проверка отображения элементов на первой странице")
    @AllureId("34661")
    void checkFirstScreenElementsTest() {
        firstScreen
                .checkLogoImageVisible()
                .checkTitleTextViewVisible()
                .checkNewUserButtonVisible()
                .checkOldUserButtonVisible()
                .checkOfferTextViewVisible()
                .checkSupportButtonVisible();
    }
}
