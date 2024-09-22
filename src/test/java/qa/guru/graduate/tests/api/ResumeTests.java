package qa.guru.graduate.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import qa.guru.graduate.pages.apiSteps.ResumeSteps;

import static qa.guru.graduate.helpers.TestData.createResumeModel;
import static qa.guru.graduate.helpers.TestData.generateResumeTitle;

public class ResumeTests extends ApiTestBase {

    @Test
    @Tags({
            @Tag("api"),
            @Tag("all")
    })
    @DisplayName("Проверка созданния реззюме")
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
                        "Проверка, соответсвия названий ожидаемого и созданного резюме")
                .comparisonFields(
                        countResumesBefore.getFound() + 1,
                        allResumes.getFound(),
                        "Проверка, что текущее количество резюме больше на одно, чем до создания нового")
                .comparisonFields(
                        expectedResume.getArea(),
                        createdModel.getArea(),
                        "Проверка, соответсвия локаций ожидаемого и созданного резюме")
                .comparisonFields(
                        expectedResume.getContact(),
                        createdModel.getContact(),
                        "Проверка, соответсвия контактов ожидаемого и созданного резюме")
                .comparisonFields(
                        expectedResume.getEducation(),
                        createdModel.getEducation(),
                        "Проверка, соответсвия образования ожидаемого и созданного резюме");
    }

    @Test
    @Tags({
            @Tag("api"),
            @Tag("all")
    })
    @DisplayName("Проверка удаления созданного реззюме")
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
