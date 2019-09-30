package tests;

import org.testng.annotations.Test;

import static core.Application.atStartPage;

public class TestStartPage {

    @Test
    public void navigateToStartPageTest() {
        atStartPage()
                .openPizzaOrderForm()
                .assertPizzaOrderFormTransition();
    }
}
