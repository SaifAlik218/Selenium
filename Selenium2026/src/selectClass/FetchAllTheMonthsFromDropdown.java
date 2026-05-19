package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locator.PreCondition;

public class FetchAllTheMonthsFromDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://practice.expandtesting.com/dropdown#google_vignette");
		Thread.sleep(4000);
		WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
		Select select = new Select(simpleDropDown);
		List<WebElement> alloptions = select.getOptions();
		for (WebElement options : alloptions) {
			System.out.println(options.getText());
		}
		PreCondition.closeBrowser(driver);
	}
}
