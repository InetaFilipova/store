import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import store_rd.BaseTest;
import store_rd.pages.IProductItem;
import store_rd.pages.MainPage;

import java.util.Optional;

public class CheckoutTest extends BaseTest {

    private MainPage mainPage;
    private static final String SEARCH_IPHONE_TEXT = "iphone 14 black";
    private static final String SEARCH_AIRPODS_TEXT = "airpods";

    @BeforeClass
    public void setUp() {
        mainPage = start();
    }

    @Test
    public void checkoutTest() {
        addProductToBasket(SEARCH_IPHONE_TEXT);
        addProductToBasket(SEARCH_AIRPODS_TEXT);
        proceedToCheckout();
    }

    private void proceedToCheckout() {
        mainPage.goToBasket().proceedToCheckout();
    }

    private void addProductToBasket(String searchText) {
        Optional<IProductItem> firstItem = mainPage
                .performSearch(searchText)
                .getFirstItem();
        Assert.assertTrue(firstItem.isPresent(),
                "There is no any item on the search result page");
        firstItem.get()
                .openItemDescription()
                .addToBasket()
                .continueShopping();
    }

    @AfterClass
    public void tearDown() {
        stopDriver();
    }
}
