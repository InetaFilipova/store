package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasketPage {

    private final By checkoutForm = By.xpath("//form[@id='order_form']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        waitUntilElementPresented(checkoutForm);
    }
}
