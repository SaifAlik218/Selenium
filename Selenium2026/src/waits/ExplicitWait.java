package waits;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://trello.com/");
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement emailAddressField = explicitWait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("email"))));
			if (emailAddressField.isDisplayed()) {
				emailAddressField.sendKeys("saifalik218");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred " + e.getStackTrace());
		}

		PreCondition.closeBrowser(driver);
	}
}
