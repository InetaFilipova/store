package store_rd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends HeaderPage {

    private final By homePageBanner = By.xpath("//div[@data-plugin='firstPageBannersSlider']");
    private final By cookiesAnnouncement = By.xpath("//div[@id='CybotCookiebotDialog']");
    private final By cookiesAcceptBtn = By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    public MainPage(WebDriver driver) {
        super(driver);
        waitUntilElementClickable(homePageBanner);
    }

    public boolean isCookiesAnnouncementPresented() {
        return elementPresented(cookiesAnnouncement);
    }

    public MainPage handleCookiesAnnouncement() {
        if (isCookiesAnnouncementPresented()) {
            waitUntilElementClickable(cookiesAcceptBtn).click();
        }
        return new MainPage(driver);
    }
}
