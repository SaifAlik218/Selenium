package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class LinksInAscending_DescendingOrder {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.myntra.com/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		List<String> ascendingOrderLinks = new ArrayList<String>();
		List<String> descendingOrderLinks = new ArrayList<String>();
		for(WebElement order : allLinks)
		{
			String orderLink = order.getText().trim();
			if (!orderLink.isEmpty()) {
				ascendingOrderLinks.add(orderLink);
				descendingOrderLinks.add(orderLink);
			}
		}
		Collections.sort(ascendingOrderLinks);
		Collections.sort(descendingOrderLinks, Collections.reverseOrder());
		System.out.println("----------Ascending order--------------");
		for (String link : ascendingOrderLinks) {
			System.out.println(link);
		}
		System.out.println("----------Descending order----------");
		for (String link : descendingOrderLinks) {
			System.out.println(link);
		}
		PreCondition.closeBrowser(driver);
	}

}
