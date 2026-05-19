package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locator.PreCondition;

public class SelectSingleDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
		Thread.sleep(3000);
		WebElement stateDropdown = driver.findElement(By.id("select3"));
		Select select = new Select(stateDropdown);
		List<WebElement> listOfCountryCode = select.getOptions();
		for (WebElement countrycode : listOfCountryCode) {
			
			System.out.println(countrycode.getText());
		}
		PreCondition.closeBrowser(driver);
	}

}
