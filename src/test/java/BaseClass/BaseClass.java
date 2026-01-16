package BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageClasses.HomePage;
import PageClasses.MyShoppingCart;
import Utilities.ExtentReportManager;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	public void openBrowser(String browserName) {
		String basePath = System.getProperty("user.dir") + "/src/main/resources/Drivers/";
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", basePath + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", basePath + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", basePath + "msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public HomePage openFlipkart() {
		driver.get("https://www.flipkart.com/");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		return PageFactory.initElements(driver, HomePage.class);
	}

	@FindBy(xpath = "//div/div/div/a[@class='WGWdFn']")
	WebElement cartButton;

	@FindBy(xpath = "//a/img[@title='Flipkart']")
	WebElement flipkartLogo;

	public MyShoppingCart GoToCart() {
		cartButton.click();
		return PageFactory.initElements(driver, MyShoppingCart.class);
	}

	public HomePage GoToHomePage() {
		flipkartLogo.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public void takeScreenShot() throws IOException {
		String filePath = System.getProperty("user.dir") + "/Screenshots/" + generateFile();
//		String filePath = System.getProperty("user.dir") + "/Screenshots/screenshot.png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filePath));
	}

	public String generateFile() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png";
	}

}
