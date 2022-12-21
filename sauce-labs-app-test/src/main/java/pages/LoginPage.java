package pages;

import config.GlobalVariable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    AppiumDriver<MobileElement> appiumDriver;
    GlobalVariable globalVariable = new GlobalVariable();

    private final By inputUsername = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By inputPassword = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By buttonLogin = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");

    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputLogin() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        setText(inputUsername, globalVariable.username);
        setText(inputPassword, globalVariable.password);
    }

    public void clickLogin() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        clickElement(buttonLogin);
    }
}