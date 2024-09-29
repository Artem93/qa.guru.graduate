package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static qa.guru.graduate.helpers.Constants.*;

public class GeneralPage {

    private final SelenideElement headerBlock = $("[data-sentry-component=\"SupernovaOverlayMenu\"]");
    private final SelenideElement mainMenuAreaSwitcherHyperText = headerBlock.$("[data-qa=\"mainmenu_areaSwitcher\"]");
    private final SelenideElement ApplicantText = headerBlock.$$("[data-sentry-component=\"MainContent\"]")
            .findBy(text(mainMenuApplicantText));
    private final SelenideElement mainMenuEmployerHyperText = headerBlock.$("[data-qa=\"mainmenu_employer\"]");
    private final SelenideElement mainMenuExpertResumeHyperText = headerBlock.$("[data-qa=\"mainmenu_expertresume\"]");
    private final SelenideElement mainMenuApplicantServicesHyperText = headerBlock.$("[data-qa=\"mainmenu_applicantServices\"]");
    private final SelenideElement searchInput = $("#a11y-search-input");


    @Step("Проверка отображения кнопки переключения локации")
    public GeneralPage checkVisibleAreaSwitcher() {
        mainMenuAreaSwitcherHyperText
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка, что в кнопке переключения локации выбран город {city}")
    public GeneralPage checkAreaSwitcherContainCity(String city) {
        mainMenuAreaSwitcherHyperText
                .shouldBe(visible)
                .shouldHave(text(city));
        return this;
    }

    @Step("Клик по кнопке переключения локации")
    public GeneralPage clickAreaSwitcher() {
        mainMenuAreaSwitcherHyperText
                .click();
        return this;
    }

    @Step("Проверка отображения элемента соискателя в хедере")
    public GeneralPage checkVisibleApplicantElement() {
        ApplicantText
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка отображения элемента работодателя в хедере")
    public GeneralPage checkEmployerElement() {
        mainMenuEmployerHyperText
                .shouldHave(text(mainMenuEmployerText));
        return this;
    }


    @Step("Клие по кнпоке работодателя в хедере")
    public GeneralPage clickEmployerElement() {
        mainMenuEmployerHyperText
                .click();
        return this;
    }

    @Step("Клик по кнпоке экспертного резюме")
    public GeneralPage checkExpertResumeElement() {
        mainMenuExpertResumeHyperText
                .shouldHave(text(mainMenuExpertResumeText));
        return this;
    }

    @Step("Проверка отображения кнопки ведущей ко всем сервисам")
    public GeneralPage checkApplicantServicesElement() {
        mainMenuApplicantServicesHyperText
                .shouldHave(text(mainMenuApplicantServicesText));
        return this;
    }

    @Step("Ввод и выполнение поискового запроса {request}")
    public GeneralPage setSearchRequest(String request) {
        searchInput
                .setValue(request)
                .pressEnter();
        return this;
    }
}
