package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    AppiumDriver<MobileElement> appiumDriver;

    private final By productImage = By.xpath("//android.widget.ImageView[@content-desc='Sauce Lab Back Packs']");
    private final By blueColor = By.xpath("//android.widget.ImageView[@content-desc='Blue color']");
    private final By addQty = By.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private final By countQty = By.id("com.saucelabs.mydemoapp.android:id/noTV");
    private final By buttonAddToCart = By.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By countCartBadge = By.id("com.saucelabs.mydemoapp.android:id/cartTV");

    public ProductPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickProduct() {
        clickElement(productImage);
    }

    public void addQuantity() {
        swipeUp(1);
        clickElement(blueColor);
        do {
            clickElement(addQty);
        } while (!getText(countQty).equals("2"));
    }

    public void clickAddToCart() {
        if (getText(countQty).equals("2")) {
            clickElement(buttonAddToCart);
        }
        if (getText(countCartBadge).equals("2")) {
            clickElement(countCartBadge);
        }
    }
}