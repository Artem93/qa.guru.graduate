package qa.guru.graduate.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.pages.mobileScreens.FirstScreen;

public class FirstScreenTests extends MobileTestBase {

    private static final FirstScreen firstScreen = new FirstScreen();

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("all")
    })
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
