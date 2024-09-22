package qa.guru.graduate.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.guru.graduate.pages.apiSteps.EducationalSteps;

import static qa.guru.graduate.helpers.TestData.*;

public class EducationalInstitutionsTests extends ApiTestBase {

    @Test
    @Tags({
            @Tag("api"),
            @Tag("all")
    })
    @DisplayName("Проверка запроса инфо об учебном заведении с валидным Id")
    void positiveEducationalRequestWithIdTest() {
        var testModel = getTestEducationalModelRu();
        var educationalSteps = new EducationalSteps();
        var response = educationalSteps
                .getEducationalItemById(testModel.getItems().get(0).getId());
        educationalSteps
                .comparisonFields(testModel, response, "Проверка ответа на валидность");
    }

    @ValueSource(strings = {";", "q", "я", "string"})
    @ParameterizedTest(name = "Невалидный id '' {0} ''")
    @Tags({
            @Tag("api"),
            @Tag("all")
    })
    @DisplayName("Проверка запроса инфо об учебном заведении с невалидным Id")
    void checkNegativeEducationalRequestTest(String badId) {
        var testModel = getBadArgumentTestEducationalModel();
        var educationalSteps = new EducationalSteps();
        var response = educationalSteps
                .requestEducationalWithBadId(badId);
        educationalSteps
                .comparisonFields(testModel.getErrors(), response.getErrors(), "Проверка соответствия ошибок");
    }

    @Test
    @Tags({
            @Tag("api"),
            @Tag("all")
    })
    @DisplayName("Проверка запроса инфо об учебном заведении с валидным параметрами Id и locale")
    void positiveEducationalRequestWithIdAndEnLocaleTest() {
        var testModel = getTestEducationalModelEn();
        var educationalSteps = new EducationalSteps();

        var response = educationalSteps
                .getEducationalItemByIdAndLocale(testModel.getItems().get(0).getId(), "EN");
        educationalSteps
                .comparisonFields(testModel, response, "Проверка соответствия моделей");
    }
}
