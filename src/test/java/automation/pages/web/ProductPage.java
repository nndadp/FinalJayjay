package automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    private WebDriverWait wait;

    By addCart = By.cssSelector("a.btn.btn-success.btn-lg\n");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void getProductPage(){
        driver.get("https://demoblaze.com/prod.html?idp_=1");
    }

    public void addtoCart(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(addCart));
        driver.findElement(addCart).click();
    }


}
