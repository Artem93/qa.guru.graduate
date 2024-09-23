package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ModalLoginPage {
    private static final SelenideElement modalWindow = $("[data-qa=\"bloko-modal\"]");
    private static final SelenideElement closeButton = $("[data-qa=\"bloko-modal-close\"]");

    @Step("Скрытие модального окна после первого поиска")
    public ModalLoginPage closeModalPage() {
        closeButton.click();
        modalWindow.shouldNotBe(exist);
        return this;
    }
}
