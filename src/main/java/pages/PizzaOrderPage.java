package pages;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PizzaOrderPage {
    public PizzaOrderPage addPizzaMargaritaToCart() {
        $(".vegetarian a[data-name=margarita]").hover().click();
        $(".btn.btn-order").shouldNotBe(visible);
        $("div.full-cart").shouldNotHave(cssClass("hide"));
        return this;
    }

    public PizzaOrderPage openCart() {
        $("div.full-cart").hover().click();
        $(".container.full-container.checkout").shouldBe(visible);
        return this;
    }

    public PizzaOrderPage fillOutDeliveryAddress() {
        $("input[value=courier]").hover().click();
        $("input#cartinfo_first_name").hover().click();
        $("input#cartinfo_first_name").val("John Doe");
        $("input#cartinfo_phone").hover().click();
        $("input#cartinfo_phone").val("1-925-2435-234");
        $("input#cartinfo_address").hover().click();
        $("input#cartinfo_address").val("220 Birchfield Dr, Marietta, GA 30068, USA");
        return this;
    }

    public PizzaOrderPage fillOutDeliveryTime() {
        $("input#cartinfo_type_delivery_inhour").hover().click();
        return this;
    }

    public void confirmTheOrder() {
        $("a.btn.btn-checkout-cart").hover().click();
    }
}
