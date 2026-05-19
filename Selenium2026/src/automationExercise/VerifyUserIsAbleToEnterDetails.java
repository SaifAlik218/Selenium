package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyUserIsAbleToEnterDetails extends VerifyUserIsAbleToEnterNameAndAdress {
	protected static String password = "saif1234@1234";

	public static void enterUserDetails() {
		driver = enterUserAndEmailAddress();
		String signPageURL = "https://automationexercise.com/signup";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		FluentWait<WebDriver> fluentwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200));
		try {
			if (driver.getCurrentUrl().equals(signPageURL)) {
				WebElement userNameField = fluentwait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
				String enteredUsername = userNameField.getAttribute("value");
				if (enteredUsername.contains(userName)) {
					System.out.println(enteredUsername + " User name field has correct name");
				} else {
					System.out.println(enteredUsername + " incorrect user name");
				}
				WebElement titleRadioButton = fluentwait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Mr']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Mr']")));
				titleRadioButton.click();
				WebElement emailAddressField = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
				if (!emailAddressField.isEnabled()) {
					System.out.println("Email address field is disabled");
				} else {
					System.out.println("Email address field is enabled");
				}
				WebElement scroll = driver.findElement(By.xpath("//label[text()='First name ']"));
				Point locationOfFirstName = scroll.getLocation();
				int x = locationOfFirstName.getX();
				int y = locationOfFirstName.getY();
				js.executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
				WebElement passwordField = fluentwait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
				passwordField.sendKeys(password);
				WebElement dayDropdown = fluentwait.until(ExpectedConditions.elementToBeClickable(By.id("days")));
				Select select = new Select(dayDropdown);
				select.selectByIndex(8);

			} else {
				System.out.println("incorrect URL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		enterUserDetails();
	}

}
