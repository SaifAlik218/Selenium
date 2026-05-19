package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class VerifyUserIsAbleToEnterNameAndAdress {
	WebDriver driver;

	public static WebDriver enterUserAndEmailAddress() {
		String className = VerifyUserIsAbleToEnterNameAndAdress.class.getSimpleName();
		String userName = "Saif";
		String emailAddress = "saif" + System.currentTimeMillis() + "@gmail.com";
		WebDriver driver = VerifyUserIsAbleToSignIn.newUserSignup();
		String loginURL = "https://automationexercise.com/login";
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		String validationText = "New User Signup!";
		try {
			if (driver.getCurrentUrl().equals(loginURL) && signUpText.getText().equals(validationText)) {
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(userName);
				driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(emailAddress);
				WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Signup']"));
				explicitWait.until(ExpectedConditions.elementToBeClickable(signUpButton));
				TakeScreenShot.sucessTakeScreenShot(driver, className);
				signUpButton.click();
				System.out.println("User details entered successfully");
				explicitWait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//b[text()='Enter Account Information']")));
				WebElement accountInfoText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
				if (accountInfoText.isDisplayed()) {
					System.out.println("User successfully landed on sign up page");
					TakeScreenShot.sucessTakeScreenShot(driver,
							className);
				} else {
					System.out.println("User failed to land on sign up page");
					TakeScreenShot.failTakeScreenShot(driver,className);
				}
			} else {
				System.out.println("Validation failed");
				TakeScreenShot.failTakeScreenShot(driver, className);
			}
		} catch (Exception e) {
			System.out.println("No such element found..");
			e.printStackTrace();
		}
		PreCondition.closeBrowser(driver);
		return driver;
	}

}
