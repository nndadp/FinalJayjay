package automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class CartPage {

    WebDriver driver;
    private WebDriverWait wait;

    By cartNav = By.id("cartur");
    By cartData = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr");
    By orderButton = By.cssSelector("button.btn.btn-success\n");
    By orderModal = By.id("orderModal");
    By orderfieldName = By.id("name");
    By orderfieldCountry = By.id("country");
    By orderfieldCity = By.id("city");
    By orderfieldCard = By.id("card");
    By orderfieldMonth = By.id("month");
    By orderfieldYear = By.id("year");
    By deleteButton = By.xpath("//a[text()='Delete']");
    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"); //
    By closeOrderModal = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By successPurchase = By.xpath("/html/body/div[10]");
    By closeSuccessAlert = By.xpath("/html/body/div[10]/div[7]/div/button");

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void cartData(){

        wait.until(ExpectedConditions.elementToBeClickable(cartNav)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartData));

    }

    public void placeOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(orderButton).click();
    }

    public void orderData(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderModal));
        driver.findElement(orderfieldName).sendKeys("TestPerson");
        driver.findElement(orderfieldCountry).sendKeys("Japan");
        driver.findElement(orderfieldCity).sendKeys("Tokyo");
        driver.findElement(orderfieldCard).sendKeys("1111222");
        driver.findElement(orderfieldMonth).sendKeys("05");
        driver.findElement(orderfieldYear).sendKeys("2025");

    }

    public void clickPurchase(){

        jsClick(wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)));
    }

    public String purchasevalidation(){
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(successPurchase));
        return popup.getText();
    }

    public void setCloseSuccessAlert(){
        driver.findElement(closeSuccessAlert).click();
    }

    public void setCloseOrderModal(){
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(closeOrderModal)));
    }

    public void clearCart(){
        List<WebElement> deleteLinks = driver.findElements(deleteButton);
        while (!deleteLinks.isEmpty()) {
            WebElement firstLink = deleteLinks.get(0);
            firstLink.click();
            wait.until(ExpectedConditions.stalenessOf(firstLink));  // wait until the row is removed
            deleteLinks = driver.findElements(deleteButton);        // re-fetch after DOM changes
        }
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartData).isEmpty();
    }

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
