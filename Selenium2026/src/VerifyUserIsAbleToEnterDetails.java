import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practice.VerifyUserIsAbleToEnterNameAndAdress;

public class VerifyUserIsAbleToEnterDetails extends VerifyUserIsAbleToEnterNameAndAdress
{
	public static WebDriver enterUserDetails()
	{
		WebDriver driver = VerifyUserIsAbleToEnterNameAndAdress.enterUserAndEmailAddress();
		String signPageURL = "https://automationexercise.com/signup";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
		if(driver.getCurrentUrl().equals(signPageURL))
		{	
			WebElement titleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Mr']")));
			titleRadioButton.click();
		}
		else
		{
			System.out.println("incorrect URL");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}
