package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class SearchResultPage extends BasePage {

    private final By body = By.xpath("//nav[@itemscope]");
    private final By item = By.xpath("//ul[contains(@class,'block-none-bottom')]//li[@data-prod-id]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public Optional<IProductItem> getFirstItem() {
        if (elementPresented(item)) {
            return Optional.of(new ItemPage(driver, waitUntilElementPresented(item)));
        } else {
            return Optional.empty();
        }
    }
}
