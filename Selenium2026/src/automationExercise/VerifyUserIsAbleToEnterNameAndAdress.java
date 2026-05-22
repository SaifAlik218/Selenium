package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class VerifyUserIsAbleToEnterNameAndAdress {

	protected static WebDriver driver;
	protected static WebElement userNameField;
	protected static WebElement emailAddressField;
	static String className = VerifyUserIsAbleToEnterNameAndAdress.class.getSimpleName();
	protected static String userName = "Saif";
	public static WebDriver enterUserAndEmailAddress() {
		driver = VerifyUserIsAbleToSignIn.newUserSignup();// calling another method and initiazation
		String loginURL = "https://automationexercise.com/login";
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		String validationText = "New User Signup!";
		try {
			if (driver.getCurrentUrl().equals(loginURL) && signUpText.getText().equals(validationText)) {
				userNameField = explicitWait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));
				userNameField.sendKeys(userName);
				emailAddressField = explicitWait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Email Address'])[2]")));
				emailAddressField.sendKeys(createEmailAddress());
				WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Signup']"));
				explicitWait.until(ExpectedConditions.elementToBeClickable(signUpButton));
//				TakeScreenShot.sucessTakeScreenShot(driver, className);
				signUpButton.click();
				System.out.println("User details entered successfully");
				WebElement accountInfoText = explicitWait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//b[text()='Enter Account Information']")));
				if (accountInfoText.isDisplayed()) {
					System.out.println("User successfully landed on sign up page");
//					TakeScreenShot.sucessTakeScreenShot(driver, className);
				} else {
					System.out.println("User failed to land on sign up page");
//					TakeScreenShot.failTakeScreenShot(driver, className);
				}
			} else {
				System.out.println("Validation failed");
//				TakeScreenShot.failTakeScreenShot(driver, className);
			}
		} catch (Exception e) {
			 throw new RuntimeException("Failed while entering signup details", e);
		}
		return driver;
	}
	public static String createEmailAddress()
	{
		return "saif" + System.currentTimeMillis() + "@gmail.com";
	
	}

}
