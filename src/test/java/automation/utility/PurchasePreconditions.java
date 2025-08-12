package automation.utility;

import org.openqa.selenium.WebDriver;
import automation.pages.web.*;

public class PurchasePreconditions {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    public PurchasePreconditions(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);

    }

    public void navigateToHomePage() {
        homePage.gotoPage();
        homePage.getLogin();
        homePage.getLoginModal();
    }

    public void performLogin(String username, String password) {
        loginPage.dologin(username, password);
        loginPage.setLoginButton();
        homePage.validateUserLogin();
    }

    public void addProductToCart() {
        homePage.getProduct();
        productPage.addtoCart();
    }

    public void gotoCartPage() {
        cartPage.cartData();
    }


}
