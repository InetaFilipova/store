package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ItemPage extends BasePage implements IProductItem {

    private final By cardBtn = By.xpath(".//a[@data-plugin='cartButton']");
    private final By goToDescription = By.xpath("./a[@href]");

    private final WebElement element;

    public ItemPage(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
    }

    @Override
    public ItemDescriptionPage openItemDescription() {
        element.findElement(goToDescription).click();
        return new ItemDescriptionPage(driver);
    }

    @Override
    public InCardPopOverPage addToBasket() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        element.findElement(cardBtn).click();
        return new InCardPopOverPage(driver);
    }
}
