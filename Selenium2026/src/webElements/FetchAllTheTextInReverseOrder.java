package webElements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class FetchAllTheTextInReverseOrder {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.flipkart.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		List<WebElement> text = new ArrayList<WebElement>();
		for (int i = allLinks.size() - 1; i >= 0; i--) {
			try {
				WebElement links = allLinks.get(i);
				String link = links.getText().trim();
				if (!link.isEmpty()) {
					text.add(links);
					System.out.println(i + " " + link);
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale elements.." + e);
			}
		}
		PreCondition.closeBrowser(driver);
	}

}
