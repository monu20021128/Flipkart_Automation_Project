package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class SignUpPage extends BaseClass {

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Existing User? Log in']")
	WebElement existingUserLoginLink;
	
	@FindBy(xpath = "//input[@maxlength='10']")
	WebElement EnterMobileNumber;

	@FindBy(xpath = "//span[text()='CONTINUE']")
	WebElement ContinueButton;
	
	public void verifySignUpPage() {
		
		String expectedTitle = "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com";
		String title = driver.getTitle();
		if (title.equals(expectedTitle)) {
			System.out.println("Sign Up Page Title Verified: " + title);
		} else {
			System.out.println("Sign Up Page Title Mismatch. Expected: " + expectedTitle + ", but got: " + title);
		}		
	}

	public LoginPage clickLoginLink() {
		existingUserLoginLink.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public void signUp(String mobileNumber) {
		EnterMobileNumber.sendKeys(mobileNumber);
		ContinueButton.click();	
	}
}
