package stepdefs;

import driver.InitAppiumDriver;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class BuyProductStepDefs {

    CartPage cartPage = new CartPage(InitAppiumDriver.appiumDriver);
    LoginPage loginPage = new LoginPage(InitAppiumDriver.appiumDriver);
    ProductPage productPage = new ProductPage(InitAppiumDriver.appiumDriver);
    CheckoutPage checkoutPage = new CheckoutPage(InitAppiumDriver.appiumDriver);

    @Given("User choose the product")
    public void userChooseTheProduct() {
        productPage.clickProduct();
    }

    @When("User select color and quantity")
    public void userSelectColorAndQuantity() {
        productPage.addQuantity();
    }

    @And("User click button add to cart")
    public void userClickButtonAddToCart() {
        productPage.clickAddToCart();
    }

    @Then("Cart is correct and proceed to checkout")
    public void cartIsCorrectAndProceedToCheckout() {
        cartPage.checkCartDetail();
    }

    @When("User input username and password")
    public void userInputUsernameAndPassword() {
        loginPage.inputLogin();
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        loginPage.clickLogin();
    }

    @When("User fill in address delivery data")
    public void userFillInAddressDeliveryData() {
        checkoutPage.inputAddressDelivery();
    }

    @And("User fill in payment method detail")
    public void userFillInPaymentMethodDetail() {
        checkoutPage.inputPaymentMethod();
    }

    @When("User review data and place order")
    public void userReviewDataAndPlaceOrder() {
        checkoutPage.reviewPlaceOrder();
    }

    @Then("User successfully created an order")
    public void userSuccessfullyCreatedAnOrder() {
        checkoutPage.getMessageToContinueShopping();
    }
}