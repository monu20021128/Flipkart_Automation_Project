package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import PageClasses.FlightsBookings;
import PageClasses.HomePage;
import PageClasses.LoginPage;
import PageClasses.MyShoppingCart;
import PageClasses.ProductsPage;
import PageClasses.SignUpPage;

public class TestFlipkart extends BaseClass {

//	@Test
	public void Test1() throws InterruptedException, IOException {
		
		logger=report.createTest("Test One");
		BaseClass base = new BaseClass();
		
		logger.log(Status.INFO, "Initializing the Browser");
		base.openBrowser("chrome");
		logger.log(Status.INFO, "Opening Flipkart");
		HomePage home = base.openFlipkart();
		logger.log(Status.INFO, "Searching Product1");
		ProductsPage product1 = home.searchProduct1();
		logger.log(Status.INFO, "Applying Filters and Selecting Product1");
		product1.applyFiltersForProduct1("boAt");
		logger.log(Status.INFO, "Navigated to Product1 Page and added product to Cart");
		HomePage home2 = product1.product1();
		home2.closeLoginWindow();
		logger.log(Status.INFO, "Searching Product2");
		ProductsPage product2 = home2.searchProduct2();
		logger.log(Status.INFO, "Applying Filters and Selecting Product2");
		product2.applyFiltersForProduct2();
		logger.log(Status.INFO, "Navigated to Product2 Page and added product to Cart");
		HomePage home3 = product2.product2();
		logger.log(Status.INFO, "Navigating to Kids Section under Fashion");
		ProductsPage product3 = home3.Fashion();
		logger.log(Status.INFO, "Applying Filters and Selecting Kids Product");
		product3.verifyKidsPage();
		product3.applyFiltersForKids();
		logger.log(Status.INFO, "Print top 4 kids product details");
		HomePage home4 = product3.KidsProduct();
		logger.log(Status.INFO, "Navigating to SignUp Page");
		SignUpPage signUp = home4.GoToSignUp();
		logger.log(Status.INFO, "Verifying SignUp Page");
		signUp.verifySignUpPage();
		logger.log(Status.INFO, "Click login link from SignUp Page");
		LoginPage login = signUp.clickLoginLink();
		logger.log(Status.INFO, "Verifying Login Page");
		login.verifyLoginPage();
		logger.log(Status.INFO, "Logging in to the application");
		HomePage home5 = login.Login();
		logger.log(Status.INFO, "Navigating to Cart");
		MyShoppingCart cart = home4.MyCart();
		logger.log(Status.INFO, "Verifying Cart Page");
		try {
			cart.verifyCartPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(Status.INFO, "Removing a product from Cart");
		HomePage home6= cart.removeProductsFromCart();
		logger.log(Status.INFO, "Navigating to Flights Booking Page");
		FlightsBookings flight=home6.goToFlights();
		logger.log(Status.INFO, "Verifying Flights Booking Page and Booking a Ticket");
		flight.verifyFlightsPageAndBookTicket();	
		logger.log(Status.FAIL, "Test Case Failed");
	}

	@Test
	public void Test2() throws InterruptedException, IOException {
		logger=report.createTest("Test Two");
		BaseClass base = new BaseClass();
		
		logger.log(Status.INFO, "Initializing the Browser");
		base.openBrowser("Chrome");
		
		logger.log(Status.INFO, "Opening Flipkart");
		HomePage home = base.openFlipkart();
		logger.log(Status.INFO, "Navigating to Kids Section under Fashion");
		ProductsPage product=home.Fashion();
		logger.log(Status.INFO, "Verifying kids Page and Applying Filters");
		product.verifyKidsPage();
		product.applyFiltersForKids();
		logger.log(Status.INFO, "Listing top 4 Kids Product Details in Console");
		HomePage home2=product.KidsProduct();
		home2.closeLoginWindow();
		logger.log(Status.PASS, "Test Case Passed");
		
	}
	
	@Test
	public void Test3() throws InterruptedException, IOException {
		logger=report.createTest("Test Three");
		BaseClass base = new BaseClass();
		
		logger.log(Status.INFO, "Initializing the Browser");
		base.openBrowser("Chrome");
		
		logger.log(Status.INFO, "Opening Flipkart");
		HomePage home = base.openFlipkart();
		logger.log(Status.INFO, "Searching Product1");
		ProductsPage product1 = home.searchProduct1();
		logger.log(Status.INFO, "Applying Filters and Selecting Product1");
		product1.applyFiltersForProduct1("boAt");
		logger.log(Status.INFO, "Navigated to Product1 Page and added product to Cart");
		HomePage home2 = product1.product1();
		home2.closeLoginWindow();
		
	}
	
	@Test
	public void Test4() throws InterruptedException, IOException {
		logger=report.createTest("Test Three");
		BaseClass base = new BaseClass();
		
		logger.log(Status.INFO, "Initializing the Browser");
		base.openBrowser("firefox");
		
		logger.log(Status.INFO, "Opening Flipkart");
		HomePage home = base.openFlipkart();
		
		ProductsPage product2=home.searchProduct2();
		product2.applyFiltersForProduct2();
		product2.product2();
	}
	
	
	@AfterMethod
    public void flush() {
    	report.flush();
    }
	
	
}
