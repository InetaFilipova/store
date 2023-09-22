package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InCardPopOverPage extends BasePage {

    private final By body = By.xpath("//div[@class='in-cart-popover__info']");
    private final By toShopping = By.xpath("//div[@class='in-cart-popover__info']//a[contains(@class, 'btn--primary')]");
    private final By toBasket = By.xpath("//a[contains(@class, 'btn--secondary')]");

    public InCardPopOverPage(WebDriver driver) {
        super(driver);
        waitUntilElementPresented(body);
    }

    public void continueShopping() {
        waitUntilElementClickable(toShopping).click();
    }

    public BasketPage proceedToBasket() {
        waitUntilElementClickable(toBasket).click();
        return new BasketPage(driver);
    }
}
