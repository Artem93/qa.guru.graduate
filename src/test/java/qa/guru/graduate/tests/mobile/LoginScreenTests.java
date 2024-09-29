package qa.guru.graduate.tests.mobile;

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

@Epic("Mobile tests")
@Feature("Login screen")
@DisplayName("Login screen tests")
public class LoginScreenTests extends MobileTestBase {

    private static final LoginScreen loginScreen = new LoginScreen();
    private static final FirstScreen firstScreen = new FirstScreen();

    @Tags({
            @Tag("mobile"),
            @Tag("all")
    })
    @Owner("Artem Lepkin")
    @Test
    @DisplayName("Проверка отображения списка методов логина")
    void checkListLoginMethods() {
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
