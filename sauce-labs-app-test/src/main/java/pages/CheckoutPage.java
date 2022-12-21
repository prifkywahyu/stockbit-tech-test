package pages;

import config.GlobalVariable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    AppiumDriver<MobileElement> appiumDriver;
    GlobalVariable globalVariable = new GlobalVariable();

    private final By inputFullname1 = By.id("com.saucelabs.mydemoapp.android:id/fullNameET");
    private final By inputFullname2 = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By inputAddress = By.id("com.saucelabs.mydemoapp.android:id/address1ET");
    private final By inputCity = By.id("com.saucelabs.mydemoapp.android:id/cityET");
    private final By inputState = By.id("com.saucelabs.mydemoapp.android:id/stateET");
    private final By inputZipCode = By.id("com.saucelabs.mydemoapp.android:id/zipET");
    private final By inputCountry = By.id("com.saucelabs.mydemoapp.android:id/countryET");
    private final By inputCardNumber = By.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
    private final By inputExpiredDate = By.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
    private final By inputSecurityCode = By.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
    private final By buttonAllPayment = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
    private final By textProductAmount = By.id("com.saucelabs.mydemoapp.android:id/priceTV");
    private final By textDeliveryAmount = By.id("com.saucelabs.mydemoapp.android:id/amountTV");
    private final By textTotalAmount = By.id("com.saucelabs.mydemoapp.android:id/totalAmountTV");
    private final By checkoutSuccessTitle = By.id("com.saucelabs.mydemoapp.android:id/completeTV");
    private final By checkoutSuccessMessage = By.id("com.saucelabs.mydemoapp.android:id/orderTV");
    private final By buttonContinueShopping = By.id("com.saucelabs.mydemoapp.android:id/shoopingBt");

    public CheckoutPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputAddressDelivery() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(inputAddress));
        setText(inputFullname1, globalVariable.fullname);
        setText(inputAddress, globalVariable.address);
        swipeUp(1);
        setText(inputCity, globalVariable.city);
        setText(inputState, globalVariable.state);
        setText(inputZipCode, globalVariable.zipCode);
        setText(inputCountry, globalVariable.country);
        if (verifyElementIsPresent(buttonAllPayment)) {
            clickElement(buttonAllPayment);
        }
    }

    public void inputPaymentMethod() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(inputCardNumber));
        setText(inputFullname2, globalVariable.fullname);
        setText(inputCardNumber, globalVariable.cardNumber);
        swipeUp(1);
        setText(inputExpiredDate, globalVariable.expiredDate);
        setText(inputSecurityCode, globalVariable.cvvCode);
        if (verifyElementIsPresent(buttonAllPayment)) {
            clickElement(buttonAllPayment);
        }
    }

    public void reviewPlaceOrder() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(textProductAmount));
        String price = getText(textProductAmount).replaceAll("[^\\d.]", "");
        swipeUp(1);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(textDeliveryAmount));
        String delivery = getText(textDeliveryAmount).replaceAll("[^\\d.]", "");
        String total = getText(textTotalAmount).replaceAll("[^\\d.]", "");
        final float expected = (Float.parseFloat(price) * 2) + Float.parseFloat(delivery);
        Assert.assertEquals(expected, Float.parseFloat(total), 0.0);
        clickElement(buttonAllPayment);
    }

    public void getMessageToContinueShopping() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(checkoutSuccessTitle));
        System.out.println(getText(checkoutSuccessTitle));
        System.out.println(getText(checkoutSuccessMessage));
        if (verifyElementNotPresent(buttonAllPayment)) {
            clickElement(buttonContinueShopping);
        }
    }
}