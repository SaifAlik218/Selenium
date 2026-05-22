package automationExercise;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class VerifyContactUsForm extends VerifyUserIsAbleToEnterDetails {
	protected static WebDriver driver;
	protected static String expectedText = "Success! Your details have been submitted successfully.";

	public static WebDriver contactUsForm() {
		driver = PreCondition.openBrowser();
		driver.get("https://automationexercise.com/contact_us");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;
		try {
			WebElement nameTextField = wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
			nameTextField.sendKeys(userName);
			WebElement emailTextField = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
			emailTextField.sendKeys(createEmailAddress());
			WebElement subjectTextField = wait.until(ExpectedConditions.elementToBeClickable(By.name("subject")));
			subjectTextField.sendKeys(getLorem());
			WebElement messageTextField = wait.until(ExpectedConditions.elementToBeClickable(By.name("message")));
			messageTextField.sendKeys(getLorem());
			WebElement uploadFile = wait.until(ExpectedConditions.elementToBeClickable(By.name("upload_file")));
			js.executeScript("arguments[0].scrollIntoView(false)", uploadFile);
			uploadFile.sendKeys("/Users/testuser/Desktop/Screenshot 2026-05-17 at 6.23.56 PM.png");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			WebElement successText = driver
					.findElement(By.xpath("(//div[contains(text(),'Success! Your details have')])[1]"));
			if (successText.getText().contains(expectedText)) {
				System.out.println("User has submitted the contact us form sucessfully");
			} else {
				System.out.println("user failed to submit the contact us form");
			}
		} catch (Exception e) {
			System.out.println("No alert popup continuing....");
		}
		return driver;
	}

	public static String getLorem() {
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
	}

	public static void main(String[] args) {
		contactUsForm();
	}
}
