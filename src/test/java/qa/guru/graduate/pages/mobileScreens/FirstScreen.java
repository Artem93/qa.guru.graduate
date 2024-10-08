package qa.guru.graduate.pages.mobileScreens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static qa.guru.graduate.helpers.Constants.*;

public class FirstScreen {

    private final SelenideElement supportButton = $(id("ru.hh.android:id/view_hh_button_small_thin_title_text_view"));
    private final SelenideElement newUserButton = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_button_new_user"));
    private final SelenideElement oldUserButton = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_button_have_account"));
    private final SelenideElement logoImage = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_image_logo"));
    private final SelenideElement titleTextView = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_text_view_logo"));
    private final SelenideElement offerTextView = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_text_view_offer"));

    @Step("Проверка видимости и кликабельности кнопки поддержки")
    public FirstScreen checkSupportButtonVisible() {
        supportButton
                .shouldHave(text(supportButtonText))
                .shouldBe(visible)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверка видимости и кликабельности кнопки для новых пользователей")
    public FirstScreen checkNewUserButtonVisible() {
        newUserButton
                .shouldHave(text(newUserButtonText))
                .shouldBe(visible)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверка видимости и кликабельности кнопки для старых пользователей")
    public FirstScreen checkOldUserButtonVisible() {
        oldUserButton
                .shouldHave(text(oldUserButtonText))
                .shouldBe(visible)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверка видимости логотипа")
    public FirstScreen checkLogoImageVisible() {
        logoImage
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости текстового заголовка")
    public FirstScreen checkTitleTextViewVisible() {
        titleTextView
                .shouldHave(text(firstScreenTitleText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости оферты")
    public FirstScreen checkOfferTextViewVisible() {
        offerTextView
                .shouldHave(text(offerText))
                .shouldBe(visible);
        return this;
    }

    @Step("Клик по кнопке поддержки")
    public FirstScreen clickSupportButton() {
        supportButton.click();
        return this;
    }

    @Step("Клик по кнопке для новых пользователей")
    public FirstScreen clickNewUserButton() {
        newUserButton.click();
        return this;
    }
}
