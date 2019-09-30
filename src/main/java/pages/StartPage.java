package pages;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.TestData.START_PAGE_URL;

public class StartPage {

    public StartPage openPizzaOrderForm() {
        open(START_PAGE_URL);
        $("a[data-slug=italian]").hover().click();
        return this;
    }

    public StartPage assertPizzaOrderFormTransition() {
        $("a[data-slug=italian]").shouldHave(cssClass("active"));
        return this;
    }
}
