package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locator.PreCondition;

public class SelectOptionsFromDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://practice.expandtesting.com/dropdown#google_vignette");
		WebElement dropdowns = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdowns);
		select.selectByIndex(1);
		Thread.sleep(500);
		select.selectByVisibleText("Option 2");
		Thread.sleep(500);
		PreCondition.closeBrowser(driver);
	}

}
