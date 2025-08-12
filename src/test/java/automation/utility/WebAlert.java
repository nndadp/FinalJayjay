package automation.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebAlert {

    WebDriver driver;
    WebDriverWait wait;

    public WebAlert(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void successRegistration(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();  // Switch to the alert
            String alertText = alert.getText();  // Get alert text
            Assert.assertEquals("Sign up successful.", alertText);  // Verify message
            alert.accept();  // Click "OK"
        } catch (NoAlertPresentException e) {
            Assert.fail("No messages shown");  // Fails the test if no alert
        }
    }

    public void existingAccountAlert(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();  // Switch to the alert
            String alertText = alert.getText();  // Get alert text
            Assert.assertEquals("This user already exist.", alertText);  // Verify message
            alert.accept();  // Click "OK"
        } catch (NoAlertPresentException e) {
            Assert.fail("No messages shown");  // Fails the test if no alert
        }
    }

    public void invalidLogin(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();  // Switch to the alert
            String alertText = alert.getText();  // Get alert text
            Assert.assertEquals("Wrong password.", alertText);  // Verify message
            alert.accept();  // Click "OK"
        } catch (NoAlertPresentException e) {
            Assert.fail("No messages shown");  // Fails the test if no alert
        }
    }
    public void nonExistinglogin(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();  // Switch to the alert
            String alertText = alert.getText();  // Get alert text
            Assert.assertEquals("User does not exist.", alertText);  // Verify message
            alert.accept();  // Click "OK"
        } catch (NoAlertPresentException e) {
            Assert.fail("No messages shown");  // Fails the test if no alert
        }
    }
    public void addtoCart(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();  // Switch to the alert
            String alertText = alert.getText();  // Get alert text
            Assert.assertEquals("Product added.", alertText);  // Verify message
            alert.accept();  // Click "OK"
        } catch (NoAlertPresentException e) {
            Assert.fail("No messages shown");  // Fails the test if no alert
        }
    }

    public void invalidOrder(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();  // Switch to the alert
            String alertText = alert.getText();  // Get alert text
            Assert.assertEquals("Please fill out Name and Creditcard.", alertText);  // Verify message
            alert.accept();  // Click "OK"
        } catch (NoAlertPresentException e) {
            Assert.fail("No messages shown");  // Fails the test if no alert
        }
    }
}
