package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import locator.PreCondition;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://automationexercise.com/login");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Saif");
		driver.findElement(By.xpath("//input[@type='email' and @data-qa='signup-email']")).sendKeys("saif7889@xyz.com");
		WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Signup']"));
		// “Create a FluentWait object that works using this WebDriver instance and
		// store it inside variable wait.”
		FluentWait<WebDriver> wait = new FluentWait<>(driver);//---> constructor
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(200));
		wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
		if (signUpButton.isDisplayed()) {
			signUpButton.click();
			System.out.println("User has signup successfully");
		} else {
			System.out.println("User failed to sign up");
		}
		PreCondition.closeBrowser(driver);
	}

}
