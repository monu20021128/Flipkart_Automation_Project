package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass;

public class FlightsBookings extends BaseClass{

	
	@FindBy(xpath="//div/input[@name='0-departcity']")
	WebElement From;
	
	@FindBy(xpath="//div/input[@name='0-arrivalcity']")
	WebElement To;
		
	@FindBy(xpath="//div/button/span[text()='SEARCH']")
	WebElement Search;
	
	public FlightsBookings(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyFlightsPageAndBookTicket() throws IOException {
		String expectedtitle="Flight bookings, Cheap flights, Lowest Air tickets at Flipkart.com";
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);		
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("Flights Page Title verified");
			selectJourney();
		} else {
			System.out.println("Flights Page Title not verified");
		} 
	}
	
	public void selectJourney() throws IOException {
		From.sendKeys("Nagpur");
		To.sendKeys("Raipur");
		Search.click();
		takeScreenShot();
		driver.quit();
	}
}
