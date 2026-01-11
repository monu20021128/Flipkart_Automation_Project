package PageClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

public class MyShoppingCart extends BaseClass {

	public MyShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	List<WebElement> CartProducts;

	@FindBy(xpath = "//div[text()='Remove']")
	WebElement RemoveButton;

	@FindBy(xpath = "//div/span/div/div/div[2]/span")
	WebElement CartAmount;

	@FindBy(xpath = "//button/span[text()='Place Order']")
	WebElement PlaceOrder;

	public void verifyCartPage() throws IOException, InterruptedException {
		String title = driver.getTitle();
		Assert.assertEquals(title,
				"Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
		System.out.println("Navigated to Shopping Cart Page Successfully");
		Thread.sleep(2000);
	}

	public HomePage removeProductsFromCart() throws InterruptedException, IOException {
		String Amount = CartAmount.getText();
		System.out.println();
		System.out.println("Total Cart Amount Before removing product: " + Amount);
		RemoveButton.click();
		Thread.sleep(1000);
		RemoveButton.click();
		Thread.sleep(2000);
		Amount = CartAmount.getText();
		System.out.println("Total Cart Amount after removing products: " + Amount);
		
		super.GoToHomePage();
		return PageFactory.initElements(driver, HomePage.class);
	}

}
