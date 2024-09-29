package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class AreaSwitcherPage {

    private final SelenideElement areaSwitcherBlock = $("[data-qa=\"area-switcher-welcome\"]");
    private SelenideElement getCityElement(String city) {
        return $(byTagAndText("a", city));
    }

    @Step("Проверка отображения окна перключения города")
    public AreaSwitcherPage checkVisibleAreaSwitcher() {
        areaSwitcherBlock
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка, что окно перключения города не отображается")
    public AreaSwitcherPage checkNotExistAreaSwitcher() {
        areaSwitcherBlock
                .shouldNotBe(exist);
        return this;
    }

    @Step("Выбрать город {city}")
    public AreaSwitcherPage selectCity(String city) {
        getCityElement(city).click();
        return this;
    }
}
