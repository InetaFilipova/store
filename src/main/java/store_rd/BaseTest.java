package store_rd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store_rd.pages.MainPage;
import utils.SettingsProvider;

import java.lang.invoke.MethodHandles;

public class BaseTest {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private WebDriver driver;

    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public MainPage start() {
        initDriver();
        driver.navigate().to(SettingsProvider.getPropertyValue("base.url"));
        return new MainPage(driver).handleCookiesAnnouncement();
    }

    public void stopDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                log.error(String.format("Exception while quite driver. Message: %s", e.getMessage()));
            }
        }
    }
}
