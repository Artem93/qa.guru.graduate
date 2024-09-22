package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static qa.guru.graduate.helpers.Constants.*;

public class GeneralPage {

    private static final SelenideElement mainMenuAreaSwitcherHyperText = $("[data-qa=\"mainmenu_areaSwitcher\"]");
    private static final SelenideElement ApplicantText = $$("[data-sentry-component=\"MainContent\"]")
            .findBy(text(mainMenuApplicantText));
    private static final SelenideElement mainMenuEmployerHyperText = $("[data-qa=\"mainmenu_employer\"]");
    private static final SelenideElement mainMenuExpertResumeHyperText = $("[data-qa=\"mainmenu_expertresume\"]");
    private static final SelenideElement mainMenuApplicantServicesHyperText = $("[data-qa=\"mainmenu_applicantServices\"]");
    private static final SelenideElement searchInput = $("#a11y-search-input");
    private static final SelenideElement loginButton = $("[data-qa=\"login\"]");


    @Step
    public GeneralPage checkVisibleAreaSwitcher() {
        mainMenuAreaSwitcherHyperText
                .shouldBe(visible);
        // .shouldBe(clickable);
        return this;
    }

    @Step
    public GeneralPage checkAreaSwitcherContainCity(String city) {
        mainMenuAreaSwitcherHyperText
                .shouldBe(visible)
                .shouldHave(text(city));
        return this;
    }

    @Step
    public GeneralPage clickAreaSwitcher() {
        mainMenuAreaSwitcherHyperText
                .click();
        return this;
    }

    @Step
    public GeneralPage checkVisibleApplicantElement() {
        ApplicantText
                .shouldBe(visible);
        return this;
    }

    @Step
    public GeneralPage checkEmployerElement() {
        mainMenuEmployerHyperText
                .shouldHave(text(mainMenuEmployerText));
        //  .shouldBe(clickable);
        return this;
    }


    @Step
    public GeneralPage clickEmployerElement() {
        mainMenuEmployerHyperText
                .click();
        return this;
    }

    @Step
    public GeneralPage checkExpertResumeElement() {
        mainMenuExpertResumeHyperText
                .shouldHave(text(mainMenuExpertResumeText));
        // .shouldBe(clickable);
        return this;
    }

    @Step
    public GeneralPage checkApplicantServicesElement() {
        mainMenuApplicantServicesHyperText
                .shouldHave(text(mainMenuApplicantServicesText));
        //   .shouldBe(clickable);
        return this;
    }

    @Step
    public GeneralPage setSearchRequest(String request) {
        searchInput
                .setValue(request)
                .pressEnter();
        return this;
    }

    @Step
    public GeneralPage clickLogin() {
        loginButton
                .click();
        return this;
    }
}
