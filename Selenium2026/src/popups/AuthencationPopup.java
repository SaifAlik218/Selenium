package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locator.PreCondition;

public class AuthencationPopup {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://admin:admin@demoapps.qspiders.com/ui/auth?sublist=0");
		driver.findElement(By.id("AuthLink")).click();
		PreCondition.closeBrowser(driver);

	}

}
