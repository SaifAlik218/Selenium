package selectClass;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class SearchSuggestion {
	private static String decodeUrl(String url) {
		return URLDecoder.decode(url, StandardCharsets.UTF_8);
	}

	private static void validateContains(String label, String actual, String expected) {
		String trimmedExpected = expected.trim();
		if (actual != null && actual.toLowerCase().contains(trimmedExpected.toLowerCase())) {
			System.out.println("[PASS]:" + label + " | Expected to contains | " + trimmedExpected
					+ " | Actual to contains |" + actual);
		} else {
			System.out.println("[FAIL]:" + label + " | Expected to contains | " + trimmedExpected
					+ " | Actual to contains |" + actual);
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.redbus.in/");
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(By.id("srcinput")).sendKeys("Delhi");
		Thread.sleep(3000);
		WebElement srcOutput = driver.findElement(By.xpath("//div[@aria-label='Near Delhi Airport, Delhi']"));
		action.click(srcOutput).perform();
		driver.findElement(By.id("destinput")).sendKeys("Mumbai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Mumbai Central, Mumbai']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='combobox' and contains(@aria-label,'Select Date of Journey')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='21']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();
		Thread.sleep(2000);
		String currentTitle = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		String decodedURL = decodeUrl(currentUrl);
		System.out.println("Decoded URL " + decodedURL);
		System.out.println("Page title " + currentTitle);
		validateContains("URL contains route key", decodedURL, " bus ticket");
		validateContains("URL contains source city", decodedURL, " delhi");
		validateContains("URL contains destination key", decodedURL, " mumbai");
		validateContains("URL contains date", decodedURL, " 21");
		validateContains("Title contains source", currentTitle, " Delhi");
		validateContains("Title contains destination", currentTitle, " Mumbai");
		TakeScreenShot.sucessTakeScreenShot(driver, SearchSuggestion.class.getSimpleName());
		PreCondition.closeBrowser(driver);
	}

}
