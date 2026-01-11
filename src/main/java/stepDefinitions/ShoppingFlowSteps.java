package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import BaseClass.BaseClass;
import PageClasses.HomePage;
import PageClasses.LoginPage;
import PageClasses.MyShoppingCart;
import PageClasses.ProductsPage;
import PageClasses.SignUpPage;
import io.cucumber.java.en.*;

public class ShoppingFlowSteps extends BaseClass {

    HomePage home;
    ProductsPage product;
    SignUpPage signUp;
    LoginPage login;
    MyShoppingCart cart;

    @Given("user launches the application")
    public void user_launches_the_application() {
    	BaseClass base = new BaseClass();
    	base.openBrowser("chrome");
        home = base.openFlipkart();   // inherited method
    }

    @When("user searches first product and applies filters")
    public void user_searches_first_product_and_applies_filters() throws InterruptedException {
        product = home.searchProduct1();
        product.applyFiltersForProduct1();
        home = product.product1();
    }

    @When("user searches second product and applies filters")
    public void user_searches_second_product_and_applies_filters() throws InterruptedException {
        home.closeLoginWindow();
        product = home.searchProduct2();
        product.applyFiltersForProduct2();
        home = product.product2();
    }

    @When("user navigates to sign up page")
    public void user_navigates_to_sign_up_page() {
        signUp = home.GoToSignUp();
    }

    @Then("sign up page should be displayed")
    public void sign_up_page_should_be_displayed() {
        signUp.verifySignUpPage();
    }

    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
        login = signUp.clickLoginLink();
    }

    @Then("login page should be displayed")
    public void login_page_should_be_displayed() throws InterruptedException {
        login.verifyLoginPage();
        
    }

    @When("user logs into the application")
    public void user_logs_into_the_application() throws InterruptedException, IOException {
//        home = 
        		login.Login();
    }
    
    /*
    @When("user navigates to shopping cart")
    public void user_navigates_to_shopping_cart() {
        cart = home.MyCart();
    }

    @Then("shopping cart page should be displayed")
    public void shopping_cart_page_should_be_displayed() throws InterruptedException {
        try {
			cart.verifyCartPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    */
    
}
