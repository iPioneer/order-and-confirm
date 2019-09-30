package core;

import pages.OrderConfirmationPage;
import pages.PizzaOrderPage;
import pages.StartPage;

import static com.codeborne.selenide.Selenide.page;

public class Application {
    public static StartPage atStartPage() {
        return page(StartPage.class);
    }

    public static PizzaOrderPage atPizzaOrderPage() {
        return page(PizzaOrderPage.class);
    }

    public static OrderConfirmationPage atOrderConfirmationPage() {
        return page(OrderConfirmationPage.class);
    }
}
