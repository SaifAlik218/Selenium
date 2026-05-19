package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class BlazeSelectFlight {
	public static void searchResults(WebDriver driver) throws IOException, InterruptedException {
		String resultURL = "https://blazedemo.com/purchase.php";
		try {
			WebElement searchResultPage = driver
					.findElement(By.xpath("//h3[text()='Flights from Portland to Buenos Aires: ']"));
			if (searchResultPage.isDisplayed()) {
				System.out.println("Sucessfully landed on results page.... ");
			}
			else
				System.out.println("Failed to land on results page....");
			WebElement chooseThisFlight = driver
					.findElement(By.xpath("//td[text()='9696']/../td//input[@type='submit']"));
			chooseThisFlight.click();
//			Thread.sleep(3000);
			if (driver.getCurrentUrl().equals(resultURL)) {
				TakeScreenShot.sucessTakeScreenShot(driver, BlazeSelectFlight.class.getSimpleName());
				System.out.println("Test passed " + BlazeSelectFlight.class.getSimpleName());
			}
		} catch (Exception e) {
			TakeScreenShot.failTakeScreenShot(driver, BlazeSelectFlight.class.getSimpleName());
			System.out.println("Test failed " + BlazeSelectFlight.class.getSimpleName() + e);
		}
		Thread.sleep(2000);
	}
}
