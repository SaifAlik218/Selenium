package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class IsEnabledMethod_VerificationMethod {
	// this method is used to verify whether any given element i.e checkbox or radio
	// button can be clicked or selected / interactable

	public static void main(String[] args) throws InterruptedException {
		boolean flagCheckBox = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/checkbox?sublist=0");
		Thread.sleep(3000);
		WebElement emailCheckBox = driver.findElement(By.name("Domain"));
		if (emailCheckBox.isEnabled()) {
			emailCheckBox.click();
			flagCheckBox = true;
		}
		System.out.println(flagCheckBox);
		PreCondition.closeBrowser(driver);

	}

}
