package blaze;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class BlazeUserDetailsPage {

	public static WebDriver userDetails() throws IOException, InterruptedException {
		WebDriver driver = BlazeSelectFlight.searchResults();
		WebElement userName = driver.findElement(By.id("inputName"));
		WebElement address = driver.findElement(By.id("address"));
		WebElement city = driver.findElement(By.id("city"));
		WebElement state = driver.findElement(By.id("state"));
		WebElement zipCode = driver.findElement(By.id("zipCode"));
		WebElement cardNumber = driver.findElement(By.id("creditCardNumber"));
		WebElement creditCardMonth = driver.findElement(By.id("creditCardMonth"));
		WebElement creditCardYear = driver.findElement(By.id("creditCardYear"));
		WebElement nameOnCard = driver.findElement(By.id("nameOnCard"));
		String resultURL = "https://blazedemo.com/confirmation.php";
		Actions action = new Actions(driver);
		userName.sendKeys("saif");
		address.sendKeys("304 wellington paradise");
		city.sendKeys("bengaluru");
		state.sendKeys("karnataka");
		zipCode.sendKeys("560014");
		List<WebElement> creditCards = driver.findElements(By.id("cardType"));
		for (WebElement creditCard : creditCards) {
			Select americanExpress = new Select(creditCard);
			String americanExpressCard = "American Express";
			if (creditCard.getText().contains("American")) {
				americanExpress.selectByVisibleText(americanExpressCard);
				creditCard.click();
			} else {
				System.out.println("Please select the card");
			}

		}
		cardNumber.sendKeys("1234567890");
		creditCardMonth.clear();
		creditCardMonth.sendKeys("9");
		creditCardYear.clear();
		creditCardYear.sendKeys("2018");
		nameOnCard.clear();
		nameOnCard.sendKeys("Saif");
		WebElement rememberMeCheckBox = driver.findElement(By.id("rememberMe"));
		if (!rememberMeCheckBox.isSelected()) {
			rememberMeCheckBox.click();
		}
		WebElement purchaseFlight = driver.findElement(By.cssSelector(".btn.btn-primary"));
		action.scrollToElement(purchaseFlight).perform();
		purchaseFlight.click();
		if (driver.getCurrentUrl().equals(resultURL)) {
			TakeScreenShot.sucessTakeScreenShot(driver, BlazeUserDetailsPage.class.getSimpleName());
			System.out.println("Test passed " + BlazeUserDetailsPage.class.getSimpleName());
		} else {
			TakeScreenShot.failTakeScreenShot(driver, BlazeUserDetailsPage.class.getSimpleName());
			System.out.println("Test failed " + BlazeUserDetailsPage.class.getSimpleName());
		}
		PreCondition.closeBrowser(driver);
		return driver;
	}

}