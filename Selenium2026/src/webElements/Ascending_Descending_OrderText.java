package webElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class Ascending_Descending_OrderText {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.flipkart.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		List<String> linkText = new ArrayList<String>();
		for (WebElement links : allLinks) {
			try {
				String text = links.getText().trim();
				if (!text.isEmpty()) {
					linkText.add(text);
					
				}
				
			} catch (StaleElementReferenceException e) {
				System.out.println("Skipping Stale element " + e);
			}
			Collections.sort(linkText, Collections.reverseOrder());
			for (String text : linkText) {
				System.out.println(text);
			}
		}
		PreCondition.closeBrowser(driver);
	}
}
