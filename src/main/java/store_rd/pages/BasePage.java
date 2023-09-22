package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
    }

    protected WebElement waitUntilElementPresented(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected boolean elementPresented(By by) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitUntilElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement fillElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
        return element;
    }
}
