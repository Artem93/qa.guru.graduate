package qa.guru.graduate.tests.api;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.pages.apiSteps.ResumeSteps;

import static qa.guru.graduate.helpers.TestData.createResumeModel;
import static qa.guru.graduate.helpers.TestData.generateResumeTitle;

@Tags({
        @Tag("api"),
        @Tag("all")
})
@Owner("Артём Лепкин")
@Epic("Api автотесты")
@Feature("Ручки для добавления и удаления резюме")
@DisplayName("Тесты на ручки добавления и удаления резюме")
public class ResumeTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка создания резюме")
    @AllureId("34657")
    void createResumeTest() {
        var expectedResume = createResumeModel(generateResumeTitle());
        var resumeSteps = new ResumeSteps();
        var countResumesBefore = resumeSteps
                .getAllResumes();
        resumeSteps
                .createResume(expectedResume);
        var allResumes = resumeSteps
                .getAllResumes();

        var createdModel = allResumes.getItems().get(0);

        resumeSteps
                .comparisonFields(
                        expectedResume.getTitle(),
                        createdModel.getTitle(),
                        "Проверка соответствия названий ожидаемого и созданного резюме")
                .comparisonFields(
                        countResumesBefore.getFound() + 1,
                        allResumes.getFound(),
                        "Проверка, что после создания резюме их количество увеличилось на одно")
                .comparisonFields(
                        expectedResume.getArea(),
                        createdModel.getArea(),
                        "Проверка соответствия локаций ожидаемого и созданного резюме")
                .comparisonFields(
                        expectedResume.getContact(),
                        createdModel.getContact(),
                        "Проверка соответствия контактов ожидаемого и созданного резюме")
                .comparisonFields(
                        expectedResume.getEducation(),
                        createdModel.getEducation(),
                        "Проверка соответствия образования ожидаемого и созданного резюме");
    }

    @Test
    @DisplayName("Проверка удаления созданного резюме")
    @AllureId("34655")
    void deleteResumeTest() {
        var expectedResume = createResumeModel(generateResumeTitle());
        var resumeSteps = new ResumeSteps();

        resumeSteps
                .createResume(expectedResume);
        var allResumesBeforeRemoving = resumeSteps
                .getAllResumes();
        var createResumeId = allResumesBeforeRemoving.getItems().get(0);
        resumeSteps
                .deleteResume(createResumeId.getId());
        var countResumesAfterRemoving = resumeSteps
                .getAllResumes().getFound();

        resumeSteps
                .comparisonFields(
                        allResumesBeforeRemoving.getFound() - 1,
                        countResumesAfterRemoving,
                        "Проверка, что текущее количество резюме меньше на одно, чем до удаления");
    }
}
