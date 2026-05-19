package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class VerifyIsUserAbleToEnterDataIntoTextField {
	static WebDriver driver;

	public static String enterUserName_email_password(String userName, String email, String password)
			throws InterruptedException {
		boolean isAllFieldsFilled = false;
		driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		WebElement userNameTextFieldElement = driver.findElement(By.id("name"));
		userNameTextFieldElement.clear();
		userNameTextFieldElement.sendKeys(userName);
		WebElement emailAddressField = driver.findElement(By.id("email"));
		emailAddressField.clear();
		emailAddressField.sendKeys(email);
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.clear();
		if (password.length() > 5) {
			System.out.println("Password must be atleast 5 characters");
			return "User failed to login... ";

		}
		passwordField.sendKeys(password);
		boolean allFieldsFilled = userNameTextFieldElement != null && emailAddressField != null
				&& passwordField != null;
		if (allFieldsFilled) {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			isAllFieldsFilled = true;
			return "User has logged in successfully... ";
		} else {
			if (emailAddressField == null) {
				System.out.println("email field is empty...");
			}
			if (passwordField == null) {
				System.out.println("password field is empty...");
			}
		}

		PreCondition.closeBrowser(driver);
		return " User failed to login... ";
	}

	public static void main(String[] args) {
		try {
			String results = enterUserName_email_password("Saif", "saifali@gmail.com", "1234567");
			System.out.println(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
