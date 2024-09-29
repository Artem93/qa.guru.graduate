package qa.guru.graduate.tests.mobile;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.pages.mobileScreens.FirstScreen;

@Epic("Mobile tests")
@Feature("Start screen")
public class FirstScreenTests extends MobileTestBase {

    private static final FirstScreen firstScreen = new FirstScreen();

    @Tags({
            @Tag("mobile"),
            @Tag("all")
    })
    @Owner("Artem Lepkin")
    @Test
    @DisplayName("Проверка отображения элементов на первой странице")
    void checkFirstScreenElements() {
        firstScreen
                .checkLogoImageVisible()
                .checkTitleTextViewVisible()
                .checkNewUserButtonVisible()
                .checkOldUserButtonVisible()
                .checkOfferTextViewVisible()
                .checkSupportButtonVisible();
    }
}
