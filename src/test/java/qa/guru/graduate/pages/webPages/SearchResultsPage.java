package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import qa.guru.graduate.enums.EducationEnum;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private static final SelenideElement commonTitle = $("[data-qa=\"title\"]");
    private static final ElementsCollection titlesVacancy = $$("[data-qa=\"serp-item__title-text\"]");
    private static final SelenideElement educationNotRequired =
            $("[data-qa=\"checkbox-container\"] [value=\"not_required_or_not_specified\"]");
    private static final SelenideElement educationSpecial =
            $("[data-qa=\"checkbox-container\"] [value=\"special_secondary\"]");
    private static final SelenideElement educationHigher =
            $("[data-qa=\"checkbox-container\"] [value=\"higher\"]");
    private static final SelenideElement selectedSalary = $("[name=\"salary\"][checked]");


    public SearchResultsPage checkCommonTitleContainText(String text) {
        commonTitle
                .shouldBe(visible)
                .shouldHave(text(text));
        return this;
    }

    public SearchResultsPage checkAllVacancyTitlesContainText(String text) {
        for (SelenideElement element : titlesVacancy) {
            element.shouldHave(text(text));
        }
        return this;
    }

    public SearchResultsPage checkFirstVacancyTitleContainText(String text) {
        titlesVacancy.first().shouldHave(text(text));
        return this;
    }

    public SearchResultsPage checkCheckedEducationCheckbox(EducationEnum education) {
        educationHigher.scrollIntoView(false);
        switch (education) {
            case EDUCATION_NOT_REQUIRED -> educationNotRequired.shouldBe(checked);
            case EDUCATION_SPECIAL -> educationSpecial.shouldBe(checked);
            case EDUCATION_HIGHER -> educationHigher.shouldBe(checked);
        }
        return this;
    }

    public SearchResultsPage checkValueSelectedSalary(String salary) {
        Assertions.assertEquals(salary, selectedSalary.getValue());
        return this;
    }
}
