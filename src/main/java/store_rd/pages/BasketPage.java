package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {
    private final By productsList = By.xpath("//ul[contains(@class,'product-list')]");
    private final By toCheckout = By.xpath("//a[contains(@class, 'btn--secondary')]");

    public BasketPage(WebDriver driver) {
        super(driver);
        waitUntilElementPresented(productsList);
    }

    public CheckoutPage proceedToCheckout() {
        waitUntilElementClickable(toCheckout).click();
        return new CheckoutPage(driver);
    }
}
