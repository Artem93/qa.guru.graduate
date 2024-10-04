package qa.guru.graduate.tests.mobile;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.enums.AuthButtonsEnum;
import qa.guru.graduate.pages.mobileScreens.FirstScreen;
import qa.guru.graduate.pages.mobileScreens.LoginScreen;

@Tags({
        @Tag("mobile"),
        @Tag("all")
})
@Owner("Артём Лепкин")
@Epic("Мобильные автотесты")
@Feature("Экран логина")
@DisplayName("Тесты на проверку экрана логина")
public class LoginScreenTests extends MobileTestBase {

    private static final LoginScreen loginScreen = new LoginScreen();
    private static final FirstScreen firstScreen = new FirstScreen();

    @Test
    @DisplayName("Проверка отображения списка методов логина")
    @AllureId("34662")
    void checkListLoginMethodsTest() {
        firstScreen
                .clickNewUserButton();
        loginScreen
                .checkHeader()
                .clickOtherMethodsButton();
        for (var button : AuthButtonsEnum.values()) {
            loginScreen
                    .checkAuthButton(button.getTitle());
        }

    }
}
