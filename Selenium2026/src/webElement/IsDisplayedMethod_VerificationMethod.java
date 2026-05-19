package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

// This method is used to verify whether element is present and verify the state of it
public class IsDisplayedMethod_VerificationMethod {

	public static void main(String[] args) {
		boolean flagCheckBox = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.get("https://demoapps.qspiders.com/ui/checkbox?sublist=0");

		WebElement emailCheckBox = driver.findElement(By.name("Domain"));
		if (emailCheckBox.isDisplayed()) {
			emailCheckBox.click();
			flagCheckBox = true;
		}
		System.out.println(flagCheckBox);
		PreCondition.closeBrowser(driver);
	}

}