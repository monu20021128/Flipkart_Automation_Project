
package PageClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseClass;

// LoginPage class extends BaseClass for shared WebDriver and utilities
public class LoginPage extends BaseClass {

    // WebDriver instance for this page

    // Constructor initializes the driver for this page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPage() throws InterruptedException {
		String expectedTitle = "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Login page title does not match!");
		Thread.sleep(3000);
    }
    
    // Locator for the login input field (phone/email)
    
    @FindBy(xpath = "//form[@autocomplete='on']/div/input[@autocomplete='off']")
     
    WebElement LoginField;

    // Locator for the "Request OTP" button
    @FindBy(xpath = "//button[text()='Request OTP']")
    WebElement getOTP;

    // Locator for the "Verify" button
    @FindBy(xpath = "//form/button[@type='submit']")
    WebElement verify;

    // Performs the login operation using OTP
    public HomePage Login() throws InterruptedException, IOException {

        // Enter the login credential (e.g., phone number)
        LoginField.sendKeys("7447207375");
        // Click the "Request OTP" button
        getOTP.click();

        
        
        // Wait for OTP input (manual entry)
        Thread.sleep(5000); // Pause for 15 seconds to allow manual OTP entry);
        
        // Return a new HomePage object after successful login
        return PageFactory.initElements(driver, HomePage.class);
        
    }
}

