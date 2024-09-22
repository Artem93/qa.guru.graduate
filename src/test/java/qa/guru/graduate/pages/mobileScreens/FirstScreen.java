package qa.guru.graduate.pages.mobileScreens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static qa.guru.graduate.helpers.Constants.*;

public class FirstScreen {
    private static final SelenideElement supportButton = $(id("ru.hh.android:id/view_hh_button_small_thin_title_text_view"));
    private static final SelenideElement newUserButton = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_button_new_user"));
    private static final SelenideElement oldUserButton = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_button_have_account"));
    private static final SelenideElement logoImage = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_image_logo"));
    private static final SelenideElement titleTextView = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_text_view_logo"));
    private static final SelenideElement offerTextView = $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_text_view_offer"));

    @Step("Проверка видимости кнопки поддержки")
    public FirstScreen checkSupportButtonVisible() {
        supportButton
                .shouldHave(text(supportButtonText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости кнопки для новых пользователей")
    public FirstScreen checkNewUserButtonVisible() {
        newUserButton
                .shouldHave(text(newUserButtonText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости кнопки для старых пользователей")
    public FirstScreen checkOldUserButtonVisible() {
        oldUserButton
                .shouldHave(text(oldUserButtonText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости логотипа")
    public FirstScreen checkLogoImageVisible() {
        logoImage.shouldBe(visible);
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

    @Step("Клик по кнопке для старых пользователей")
    public FirstScreen clickOldUserButton() {
        oldUserButton.click();
        return this;
    }
}
