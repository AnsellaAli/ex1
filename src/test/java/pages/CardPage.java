package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public class CardPage {

    private final By TAB_LIST = By.cssSelector(".Wrapper-sc-1vydk7-0.jLWLXd.TabText-sc-tyqhzb-3.faRXmE");
    private final By CARD_LIST = By.cssSelector(".Wrapper-sc-6nwvzq-0.kRJvZg.styled__TitleMobile-sc-m0n4zo-8.frcrJF");


    @Step("Выбрать сортировку {0}")
    public CardPage selectTab(String tabName) {
        $$(TAB_LIST).find(text(tabName)).click();
        return this;
    }

    @Step("Проверяем, что название карт содержит текст {0}")
    public CardPage checkNamesCardsContainsText(String cardName) {
        $$(CARD_LIST).shouldHave(sizeGreaterThan(0)).stream().map(SelenideElement::getOwnText).forEach(name -> assertTrue(name.contains(cardName)));
        return this;
    }
}
