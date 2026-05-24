package automationExercise;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class VerifyAllProductPage extends VerifyTestCasePage {
	protected final static String productPageURL = "https://automationexercise.com/products";
	protected final static String targetProductPageURL = "https://automationexercise.com/product_details/1";
	protected final static String productAvailablity = "In Stock";
	protected final static String productCondition = "New";
	protected final static String brandName = "Polo";

	public static WebDriver allProductPage() {
		driver = PreCondition.openBrowser();
		driver.get(URL);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			navigatingToSearchProduct();
			dismissIfAlertIsPresent();
//			dismissAdWindow();
			productDetailsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreCondition.closeBrowser(driver);
		return driver;
	}

	public static void dismissIfAlertIsPresent() {
		try {
			Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
			System.out.println("Alert dismissed");
		} catch (Exception e) {
			System.out.println("No alert present - continuing...");
		}
	}

	public static void productDetailsPage() {
		wait.until(ExpectedConditions.urlToBe(targetProductPageURL));
		System.out.println("User has sucessfully landed on product details page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Blue Top']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Category: Women > Tops']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rs. 500']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Availability:']")));
		WebElement stockAvailability = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'In Stock')]")));
		if (stockAvailability.getText().contains(productAvailablity)) {
			System.out.println("Product " + stockAvailability.getText());
		} else {
			System.out.println("Product is not available: " + stockAvailability.getText());
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Condition:']")));
		WebElement productNewCondition = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'New')]")));
		if (productNewCondition.getText().contains(productCondition)) {
			System.out.println("Product " + productNewCondition.getText());
		} else {
			System.out.println("Product " + productNewCondition.getText());
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Brand:']")));
		WebElement poloBrand = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Polo')]")));
		if (poloBrand.getText().contains(brandName)) {
			System.out.println(poloBrand.getText());
		} else {
			System.out.println("Brand name not matched : " + poloBrand.getText());
		}
	}

	public static void dismissAdWindow(String URL) {
		String landingPageUrl = driver.getCurrentUrl();
	    driver.navigate().to(landingPageUrl);
	}

	public static void navigatingToSearchProduct() {
		navigateToProductPage();
		scrollToProduct1();
		clickProduct1();
	}

	public static void navigateToProductPage() {
		driver.navigate().to(productPageURL);
		WebElement productLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/product_details/1']")));

	}

	public static void scrollToProduct1() {
		WebElement scrollToProduct1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")));
		js.executeScript("arguments[0].scrollIntoView(true)", scrollToProduct1);
	}

	public static void clickProduct1() {
		WebElement productLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/product_details/1']")));
		productLink.click();

	}

	public static void main(String[] args) {
		allProductPage();
	}
}
