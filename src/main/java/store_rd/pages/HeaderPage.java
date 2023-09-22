package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private final By headerBody = By.xpath("//header[@class='header']");
    private final By searchBox = By.xpath("//input[@name='search_string']");
    private final By openCart = By.xpath("//div[@class='cart']/a[contains(@class,'btn--cart')]");

    public HeaderPage(WebDriver driver) {
        super(driver);
        waitUntilElementPresented(headerBody);
    }

    public SearchResultPage performSearch(String searchString) {
        waitUntilElementPresented(searchBox);
        fillElement(searchBox, searchString).sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public BasketPage goToBasket() {
        waitUntilElementClickable(openCart).click();
        return new BasketPage(driver);
    }
}
