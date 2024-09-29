package qa.guru.graduate.pages.mobileScreens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static qa.guru.graduate.helpers.Constants.*;

public class SupportScreen {

    private final SelenideElement headerTitleTextView = $(id("ru.hh.android:id/view_chat_app_bar_text_view_title"));
    private final SelenideElement headerSubtitleTextView = $(id("ru.hh.android:id/view_chat_app_bar_text_view_subtitle"));
    private final SelenideElement moreButton = $(id("ru.hh.android:id/view_chat_menu_actions"));
    private final SelenideElement botMessage = $(id("ru.hh.android:id/view_chat_message_body_text_view_message"));
    private final SelenideElement attachFileButton = $(id("ru.hh.android:id/view_chat_message_input_image_attach_file"));
    private final SelenideElement textInput = $(id("ru.hh.android:id/view_chat_message_input_edit_text"));
    private final SelenideElement sendButton = $(id("ru.hh.android:id/view_chat_message_input_image_send"));

    @Step("Проверка отображения заголовка")
    public SupportScreen checkHeaderTitleText() {
        headerTitleTextView
                .shouldBe(visible)
                .shouldHave(text(supportHeaderText));
        return this;
    }

    @Step("Проверка отображения подзаголовка")
    public SupportScreen checkHeaderSubtitleText() {
        headerSubtitleTextView
                .shouldBe(visible)
                .shouldHave(text(supportSubtitleText));
        return this;
    }

    @Step("Проверка видимости и кликабельности кнопки 'Ещё'")
    public SupportScreen checkMoreButtonVisible() {
        moreButton
                .shouldBe(visible)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверка сообщения бота")
    public SupportScreen checkBotMessageText() {
        botMessage
                .shouldBe(visible)
                .shouldHave(text(botMessageText));
        return this;
    }

    @Step("Проверка видимости и кликабельности кнопки прикрепления файла")
    public SupportScreen checkAttachFileButtonVisible() {
        attachFileButton
                .shouldBe(visible)
                .shouldBe(clickable);
        return this;
    }

    @Step("Клик по кнопке прикрепления файла")
    public SupportScreen clickAttachFileButton() {
        attachFileButton.click();
        return this;
    }

    @Step("Проверка видимости поля ввода текста")
    public SupportScreen checkTextInputVisible() {
        textInput.shouldBe(visible);
        return this;
    }

    @Step("Заполнение поля ввода текста")
    public SupportScreen checkTextInputVisible(String text) {
        textInput.setValue(text);
        return this;
    }

    @Step("Проверка, что кнопка отправки видна, но некликабельна")
    public SupportScreen checkSendButtonVisible() {
        sendButton
                .shouldBe(visible)
                .shouldNotBe(clickable);
        return this;
    }

    @Step("Клик по кнопке отправки")
    public SupportScreen clickSendButton() {
        sendButton.click();
        return this;
    }
}
