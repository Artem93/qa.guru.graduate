package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static qa.guru.graduate.helpers.Constants.*;

public class EmployerPage {

    private static final SelenideElement employerTitle = $("[data-qa=\"employer-index-title\"]");
    private static final SelenideElement employerSubtitle = $("[data-qa=\"employer-index-subtitle\"]");
    private static final SelenideElement publishVacancyButton = $("[data-qa=\"employer-index-publish-vacancy\"]");

    private static SelenideElement getSpecialisationCheckbox(String specialisation) {
        return $$("[data-qa=\"checkbox-container\"]").findBy(text(specialisation));
    }

    @Step
    public EmployerPage checkVisibleEmployerTitle() {
        employerTitle
                .shouldHave(text(employerTitleText))
                .shouldBe(visible);
        return this;
    }

    @Step
    public EmployerPage checkVisibleEmployerSubtitle() {
        employerSubtitle
                .shouldHave(text(employerSubtitleText))
                .shouldBe(visible);
        return this;
    }

    @Step
    public EmployerPage checkVisiblePublishVacancyButton() {
        publishVacancyButton
                .shouldHave(text(publishVacancyButtonText))
                .shouldBe(visible);
        return this;
    }

    @Step
    public EmployerPage clickSpecialisationCheckbox(String specialisation) {
        getSpecialisationCheckbox(specialisation).click();
        return this;
    }
}
