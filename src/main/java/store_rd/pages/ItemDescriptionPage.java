package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDescriptionPage extends BasketPage{

    private final By body = By.xpath("//section[@itemscope]");
    private final By toBasket = By.xpath("//div[contains(@class,'product-info__buttons')]//a[@data-plugin='cartButton']");

    public ItemDescriptionPage(WebDriver driver) {
        super(driver);
        waitUntilElementPresented(body);
    }

    public InCardPopOverPage addToBasket() {
        waitUntilElementClickable(toBasket).click();
        return new InCardPopOverPage(driver);
    }
}
