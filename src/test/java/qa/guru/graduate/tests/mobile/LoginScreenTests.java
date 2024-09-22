package qa.guru.graduate.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.enums.AuthButtonsEnum;
import qa.guru.graduate.pages.mobileScreens.FirstScreen;
import qa.guru.graduate.pages.mobileScreens.LoginScreen;

public class LoginScreenTests extends MobileTestBase {

    private static final LoginScreen loginScreen = new LoginScreen();
    private static final FirstScreen firstScreen = new FirstScreen();

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("all")
    })
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
