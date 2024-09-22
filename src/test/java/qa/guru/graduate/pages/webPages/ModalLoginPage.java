package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ModalLoginPage {
    private static final SelenideElement modalWindow = $("[data-qa=\"bloko-modal\"]");
    private static final SelenideElement closeButton = $("[data-qa=\"bloko-modal-close\"]");

    public ModalLoginPage closeModalPage() {
        closeButton.click();
        modalWindow.shouldNotBe(exist);
        return this;
    }
}
