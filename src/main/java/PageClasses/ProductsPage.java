package PageClasses;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseClass;

public class ProductsPage extends BaseClass {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

//	Apply Filters for Product 1
	@FindBy(xpath = "//div/section[3]/div[3]/div/div[2]/div")
	WebElement slider;
	@FindBy(xpath = "//div/section/div/div[text()='Brand']")
	WebElement clickBrandButton;
	@FindBy(xpath = "//input[@placeholder='Search Brand']")
	WebElement searchBrand;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div/div/section[5]/div[2]/div[1]/div[2]/div/label/div[2]")
	WebElement Brand;
	@FindBy(xpath = "//div[text()='Price -- Low to High']")
	WebElement sortPrice;

//	Product 1
	@FindBy(xpath = "//div[@data-id]")
	List<WebElement> HeadphoneList;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div[1]/div/a[2]")
	WebElement product1;

	@FindBy(xpath = "//div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")
	WebElement productName;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement addToCartButton;

//	Apply Filters for Product 2
	@FindBy(xpath = "//div/div[3]/div[1]/div[1]/div[2]/div/div/section[7]/div[1]/div")
	WebElement Color;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/div/section[8]/div[2]/div[1]/div[1]/input")
	WebElement ShoeColor;
	@FindBy(xpath = "//div[text()='White']")
	WebElement White;
	@FindBy(xpath = "//div/div[3]/div/div[1]/div[2]/div/div/section[11]/div[1]/div")
	WebElement Offer;
	@FindBy(xpath = "//div[text()='Size - UK/India']")
	WebElement Size;
	@FindBy(xpath = "//div/span[text()='12 MORE']")
	WebElement ViewMore;
	@FindBy(xpath = "//div[text()='9']")
	WebElement Size9;
	@FindBy(xpath = "//div[text()='Brand']")
	WebElement Brands;
	@FindBy(xpath = "//div[text()='PUMA']")
	WebElement Puma;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/div/section[8]/div[2]/div[2]/span")
	WebElement MoreColors;

//	Product 2
	@FindBy(xpath = "//div[@data-id]")
	private List<WebElement> ShoesList;

//	Kids Products
	@FindBy(xpath = "//section/div[3]/div/div[2]/div")
	WebElement slider2;
	@FindBy(xpath = "//section/div/div[text()='Occasion']")
	WebElement Occasion;
	@FindBy(xpath = "//div[text()='Type']")
	WebElement Type;
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div/div/section[5]/div[2]/div[2]/span")
	WebElement MoreOccasions;
	@FindBy(xpath = "//div[text()='Casual']")
	WebElement Casual;
	@FindBy(xpath = "//div[text()='Party']")
	WebElement Party;
	@FindBy(xpath = "//div[@data-id]")
	List<WebElement> KidsProducts;

	public void applyFiltersForProduct1(String BrandName) throws InterruptedException {
		Assert.assertEquals(driver.getTitle(),
				"HeadPhones- Buy Products Online at Best Price in India - All Categories | Flipkart.com");

//		Select Price Range
		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(-150, 0).release().build().perform();

		Thread.sleep(3000);
//		Select Brand
		clickBrandButton.click();
		searchBrand.sendKeys(BrandName);
		
		Brand.click();

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofMinutes(1));
		waits.until(ExpectedConditions.elementToBeClickable(sortPrice));

//		Sort Price
		Thread.sleep(3000);
		sortPrice.click();
		

	}

	public HomePage product1() throws InterruptedException {

		Thread.sleep(2000);
		
		int count = 1;

		System.out.println();
		System.out.println("Headphones: ");
		for (WebElement headphone : HeadphoneList) {

			String productName = headphone.findElement(By.xpath(".//div[@class='RGLWAk']/a[2]")).getText();

			String price = headphone.findElement(By.xpath(".//a[@class='fb4uj3']/div/div")).getText();

			System.out.println((count) + ") Product: " + productName + " | Price: " + price);

			count++;
		}
		
		
		product1.click();

		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();

		String homePageID = itr.next();
		String ProductPageID = itr.next();

		driver.switchTo().window(ProductPageID);
		Thread.sleep(3000);

		addToCartButton.click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(homePageID);

		super.GoToHomePage();

		return PageFactory.initElements(driver, HomePage.class);
	}

	public void applyFiltersForProduct2() throws InterruptedException {

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Color);

		ShoeColor.sendKeys("White");
		White.click();

		// 2. Scroll till Brand section appears
		js.executeScript("arguments[0].scrollIntoView(true);", Brands);

		// 3. Select PUMA and NIKE brands
		Thread.sleep(2000);
		Puma.click(); // Not working without Thread.sleep

		js.executeScript("arguments[0].scrollIntoView(true);", Size);
		Thread.sleep(2000);
		Size.click(); // Not working without Thread.sleep

		wait.until(ExpectedConditions.elementToBeClickable(ViewMore));
		ViewMore.click();

		// 3. Select size 9
		wait.until(ExpectedConditions.elementToBeClickable(Size9));
		Thread.sleep(2000);
		Size9.click();

		wait.until(ExpectedConditions.elementToBeClickable(sortPrice));
		Thread.sleep(2000);
		sortPrice.click();

	}

	public HomePage product2() throws InterruptedException {
		
		Thread.sleep(2000);
		int count = 1;

		System.out.println();
		System.out.println("Shoes: ");
		for (WebElement shoes : ShoesList) {

			if (count == 6) {
				break;
			}
			String productName = shoes.findElement(By.xpath(".//div[@class='p0C73x']/a[1]")).getText();

			String price = shoes.findElement(By.xpath(".//div[@class='p0C73x']/a[2]/div/div[1]")).getText();

			System.out.println((count) + ") Product: " + productName + " | Price: " + price);

			count++;
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(ShoesList.get(0)));
		Thread.sleep(2000);
		ShoesList.get(0).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();

		String homePageID = itr.next();
		String Product1PageID = itr.next();

		driver.switchTo().window(Product1PageID);
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		addToCartButton.click();
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(homePageID);

		super.GoToHomePage();

		return PageFactory.initElements(driver, HomePage.class);
	}

	public void verifyKidsPage() {
		Assert.assertEquals(driver.getTitle(),
				"Clothes & Accessories For Men, Women & Kids Online at Best Prices In India | Flipkart.com");
	}

	public void applyFiltersForKids() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", Type);
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(Occasion));
		Occasion.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Occasion);
//		MoreOccasions.click();
		wait.until(ExpectedConditions.elementToBeClickable(Party));
		Party.click();

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Brands);
		Actions action = new Actions(driver);
		action.clickAndHold(slider2).moveByOffset(-159, 0).release().build().perform();
		Thread.sleep(2000);
	}

	public HomePage KidsProduct() {
		int count = 0;

		System.out.println();
		System.out.println("Kids Products: ");
		for (WebElement product : KidsProducts) {

			if (count == 4) {
				break;
			}

			String brand = product.findElement(By.xpath(".//div[@class='Fo1I0b']")).getText();

			String productName = product.findElement(By.xpath(".//a[starts-with(@class, 'atJtCj')]")).getText();

			String price = product.findElement(By.xpath(".//a[starts-with(@class, 'k7mUBC')]/div/div[1]")).getText();

			System.out.println((count + 1) + ") Brand: " + brand + " | Product: " + productName + " | Price: " + price);

			count++;
		}
		super.GoToHomePage();

		return PageFactory.initElements(driver, HomePage.class);
	}
}
