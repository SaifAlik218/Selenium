package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class WebElement_2 {

	public static void main(String[] args) throws InterruptedException {
		boolean isFlagButtonEnabled = false;
		boolean ischeckBoxEnabled = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/button/buttonDisabled?sublist=4");
		Thread.sleep(5000);
		WebElement yesButton = driver.findElement(By.id("btn_abc"));
		if (yesButton.isDisplayed() && yesButton.isEnabled()) {
			yesButton.click();
			isFlagButtonEnabled = true;
			WebElement termsAndConditionCheckBox = driver
					.findElement(By.xpath("//input[@type='checkbox' and @name='submit']"));
			if (isFlagButtonEnabled && termsAndConditionCheckBox.isSelected()) {
				ischeckBoxEnabled = true;
				WebElement submitButton = driver.findElement(By.id("submitButton"));
				submitButton.click();
				System.out.println("User submitted the request successfully");
			} else {
				System.out.println(termsAndConditionCheckBox.isSelected() + " : User failed to submit the request ");

			}
		}
		PreCondition.closeBrowser(driver);

	}

}
