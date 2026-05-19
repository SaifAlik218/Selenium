package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;
// This method is used to verify whether checkbox or radioButton is already checked or selected
public class IsSelectedMethod_VerificationMethod {

	public static void main(String[] args) throws InterruptedException {
		boolean flagCheckBox = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/checkbox/disabled?sublist=2");
		Thread.sleep(3000);
		WebElement emailCheckBox = driver.findElement(By.name("Domain"));
		if (!emailCheckBox.isSelected()) {
			emailCheckBox.click();
			flagCheckBox = true;
		}
		System.out.println(flagCheckBox);
		PreCondition.closeBrowser(driver);

	}

}
