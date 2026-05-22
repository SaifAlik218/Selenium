package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class FileUploadPopup {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoapps.qspiders.com/ui/fileUpload?sublist=0");
		WebElement uploadFile = driver.findElement(By.id("resume"));
		uploadFile
				.sendKeys("/Users/testuser/Desktop/Selenium/Selenium2026/ScreenShots/success_BlazeSelectFlight_6.png");
		PreCondition.closeBrowser(driver);

	}

}
