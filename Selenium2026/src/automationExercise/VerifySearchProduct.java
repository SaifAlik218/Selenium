package automationExercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class VerifySearchProduct extends VerifyAllProductPage {
	protected static String productShirt = "Shirt";
	protected static String productShirtURL = "https://automationexercise.com/products?search=shirt";
	protected static String className = VerifySearchProduct.class.getSimpleName();

	public static WebDriver searchProduct() {
		driver = PreCondition.openBrowser(URL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOfElementLocated(automationExercise));
		driver.navigate().to(productPageURL);
		searchProductBar();
		PreCondition.closeBrowser(driver);
		return driver;
	}

	private static void searchProductBar() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe(productPageURL));
		try {
			WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
			searchField.sendKeys(productShirt);
			WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_search")));
			searchButton.click();
			searchResult();
			scrollWebPage();
		} catch (Exception e) {
			System.out.println("Incorrect URL.." + e);
		}
	}

	private static void searchResult() {
		int i = 1;
		scrollWebPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Searched Products']")));
		List<WebElement> allProducts = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='productinfo text-center']/p")));
		System.out.println("Total products: " + allProducts.size());
		for (WebElement products : allProducts) {
			if (products.isDisplayed()) {
				System.out.println(i + " Product is visible: " + products.getText());
				i++;
			} else {
				System.out.println(i + " Product is not visible: " + products.getText());
				i++;
			}
		}
	}

	public static void scrollWebPage() {
		WebElement subscriptionText = driver.findElement(By.xpath("//h2[text()='Subscription']"));
		js.executeScript("arguments[0].scrollIntoView(true)", subscriptionText);
		System.out.println("Scrolled till expected: " + subscriptionText.getText());
	}
}
