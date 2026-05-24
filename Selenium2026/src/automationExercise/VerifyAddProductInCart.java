package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class VerifyAddProductInCart extends VerifyAllProductPage {
	public static WebDriver addProductToCart() {
		driver = PreCondition.openBrowser(URL);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			VerifyAllProductPage.navigateToProductPage();
			wait.until(ExpectedConditions.urlToBe(productPageURL));
			VerifyAllProductPage.scrollToProduct1();
			VerifyAllProductPage.clickProduct1();
			dismissIfAlertIsPresent();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}


	public static void main(String[] args) {
		addProductToCart();
	}
}
