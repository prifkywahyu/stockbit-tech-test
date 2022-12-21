package pages;

import config.GlobalVariable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    AppiumDriver<MobileElement> appiumDriver;
    GlobalVariable globalVariable = new GlobalVariable();

    private final By productTitle = By.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private final By countQty = By.id("com.saucelabs.mydemoapp.android:id/noTV");
    private final By buttonAddToCart = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    public CartPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void checkCartDetail() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToCart));
        Assert.assertEquals(globalVariable.productTitle, getText(productTitle));
        Assert.assertEquals("2", getText(countQty));
        clickElement(buttonAddToCart);
    }
}