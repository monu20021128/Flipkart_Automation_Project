
// Package declaration
package PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

// HomePage class extends BaseClass for shared WebDriver and utilities
public class HomePage extends BaseClass{

    // WebDriver instance for this page
    WebDriver driver;

    // Locator for the Login button
    @FindBy(xpath="//div/a/span[text()='Login']")
    WebElement LoginButton;

    // Locator for the Sign Up button
    @FindBy(xpath="//div/ul/a/span[text()='Sign Up']")
    WebElement SignUpButton;

    // Locator for the search input box
    @FindBy(xpath="//div/div/input[@title='Search for Products, Brands and More']")
    WebElement SearchBox;

    // Locator for the search button
    @FindBy(xpath="//button[@aria-label='Search for Products, Brands and More']")
    WebElement SearchButton;

    @FindBy(xpath="//div/span/span[text()='Flight Bookings']")
    WebElement FlightBookings;
    
    // Locator for the cart button
    @FindBy(xpath = "//a[text()='Cart']")
    WebElement MycartButton;
    
    @FindBy(xpath = "//div/span/span[text()='Fashion']")
    WebElement Fashion;
    
    @FindBy(xpath="//div/div[1]/object/a")
    List<WebElement> FashionCategory;
    
    // Constructor initializes WebElements using PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigates to the Login page by clicking the Login button
    public LoginPage GoToLogin() {
        LoginButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    // Navigates to the Sign Up page by hovering over Login and clicking Sign Up
    public SignUpPage GoToSignUp() {
        Actions action = new Actions(driver);
        action.moveToElement(LoginButton).build().perform();
        SignUpButton.click();
        return PageFactory.initElements(driver, SignUpPage.class);
    }

    // Searches for "HeadPhones" and navigates to the Products page
    public ProductsPage searchProduct1() {
        SearchBox.sendKeys("HeadPhones");
        SearchButton.click();
        return PageFactory.initElements(driver, ProductsPage.class);
    }

    // Searches for "Casual Shoes" and navigates to the Products page
    public ProductsPage searchProduct2() {
        SearchBox.sendKeys("Casual Shoes");
        SearchButton.click();
        return PageFactory.initElements(driver, ProductsPage.class);
    }

    // Closes the login popup window if present
    public ProductsPage closeLoginWindow() {
        driver.findElement(By.xpath("/html/body/div[4]/div/span")).click();
        return null;
    }
    
    public MyShoppingCart MyCart() {
    	MycartButton.click();
    	return PageFactory.initElements(driver, MyShoppingCart.class);
    	
    }

    public FlightsBookings goToFlights() {
    	FlightBookings.click();
    	return PageFactory.initElements(driver, FlightsBookings.class);
    }
	
    public ProductsPage Fashion() {
    	Actions action = new Actions(driver);
    	action.moveToElement(Fashion).build().perform();
    	System.out.println("Fashion Categories: ");
		for (WebElement category : FashionCategory) {
			System.out.println(category.getText());
		}
		
		for (WebElement category : FashionCategory) {
			if (category.getText().equals("Kids")) {
				category.click();
				break;
			}
		}
    	
		return PageFactory.initElements(driver, ProductsPage.class);
    }
    
    
}
