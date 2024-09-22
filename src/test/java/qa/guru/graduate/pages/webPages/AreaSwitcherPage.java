package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class AreaSwitcherPage {
    private static final SelenideElement areaSearchInput = $("input[data-qa=\"area-search-input\"]");
    private static final SelenideElement areaSwitcherBlock = $("[data-qa=\"area-switcher-welcome\"]");

    private static SelenideElement getCityElement(String city) {
        return $(byTagAndText("a", city));
    }

    @Step
    public AreaSwitcherPage checkVisibleAreaSearch() {
        areaSearchInput
                .shouldBe(visible);
        return this;
    }

    @Step
    public AreaSwitcherPage checkVisibleAreaSwitcher() {
        areaSwitcherBlock
                .shouldBe(visible);
        return this;
    }

    @Step
    public AreaSwitcherPage checkNotExistAreaSwitcher() {
        areaSwitcherBlock
                .shouldNotBe(exist);
        return this;
    }

    @Step
    public AreaSwitcherPage selectCity(String city) {
        getCityElement(city).click();
        return this;
    }
}
