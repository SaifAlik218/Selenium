package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class BlazeSearchFlight {
	static final String ScreenShot_PATH = "/Users/testuser/Desktop/Selenium/Selenium2026/src/practice/Screenshot/";

	public static void takeWebElementScreenShot(WebDriver driver, WebElement element) throws IOException {
		File folder = new File(ScreenShot_PATH);
		int count = folder.listFiles() != null ? folder.listFiles().length + 1 : 1;
		File src = element.getScreenshotAs(OutputType.FILE);
		File file = new File(ScreenShot_PATH + "webelement" + count + ".png");
		FileHandler.copy(src, file);
	}

	public static void selectSrcAndDest(WebDriver driver) throws InterruptedException, IOException {
		String resultURL = "https://blazedemo.com/reserve.php";
		driver.get("https://blazedemo.com/");
		Thread.sleep(3000);
		List<WebElement> cities = driver.findElements(By.name("fromPort"));
		for (WebElement city : cities) {
			Select select = new Select(city);
			String fromCity = "Portland";
			if (city.getText().contains(fromCity)) {
				select.selectByVisibleText(fromCity);
				city.click();
				Thread.sleep(3000);
				takeWebElementScreenShot(driver, city);
			}

		}
		List<WebElement> destinationCities = driver.findElements(By.name("toPort"));
		for (WebElement destinationCity : destinationCities) {
			Select select = new Select(destinationCity);
			String destination = "Buenos Aires";
			if (destinationCity.getText().contains(destination)) {
				select.selectByVisibleText(destination);
				destinationCity.click();
				Thread.sleep(1000);
				takeWebElementScreenShot(driver, destinationCity);
			}
		}
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(2000);
		if (driver.getCurrentUrl().equals(resultURL)) {
			TakeScreenShot.sucessTakeScreenShot(driver, BlazeSearchFlight.class.getSimpleName());
			System.out.println("Test Passed" + BlazeSearchFlight.class.getSimpleName());
		} else {
			TakeScreenShot.failTakeScreenShot(driver, BlazeSearchFlight.class.getSimpleName());
			System.out.println("Test failed" + BlazeSearchFlight.class.getSimpleName());
		}
		Thread.sleep(3000);
	}

}
