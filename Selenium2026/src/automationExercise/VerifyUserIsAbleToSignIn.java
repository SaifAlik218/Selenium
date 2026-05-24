package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class VerifyUserIsAbleToSignIn {
	protected static String URL = "https://automationexercise.com/";
	protected static WebDriver driver;
	protected static By automationExercise = By.xpath("//img[@alt='Website for automation practice']");
	protected static String className = VerifyUserIsAbleToSignIn.class.getSimpleName();
	public static WebDriver newUserSignup() {
		
		driver = PreCondition.openBrowser(URL);
		String targetURL = "https://automationexercise.com/login";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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