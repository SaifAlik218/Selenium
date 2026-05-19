package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class VerifyUserIsAbleToSignIn {

	public static WebDriver newUserSignup() {
		WebDriver driver;
		String className = VerifyUserIsAbleToSignIn.class.getSimpleName();
		driver = PreCondition.openBrowser();
		String targetURL = "https://automationexercise.com/login";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		try {
			WebElement signUpLink = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
			if (signUpLink.isDisplayed()) {
				signUpLink.click();
				if (driver.getCurrentUrl().equals(targetURL)) {
					System.out.println("User landed on login page");
//					TakeScreenShot.sucessTakeScreenShot(driver, className);
				} else {
					System.out.println("User failed to land on login page");
//					TakeScreenShot.failTakeScreenShot(driver, className);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
