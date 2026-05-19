package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class ImplicitWait {

	public static void main(String[] args) {
		boolean flagCheckBox = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/checkbox?sublist=0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement emailCheckBox = driver.findElement(By.name("Domain"));
		if (emailCheckBox.isDisplayed()) {
			emailCheckBox.click();
			flagCheckBox = true;
		}
		System.out.println(flagCheckBox);
		PreCondition.closeBrowser(driver);
	}

}
