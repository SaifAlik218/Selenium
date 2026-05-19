package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class ElementsExist {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.myntra.com/");
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		if(buttons.size() > 0)
		{
			System.out.println("Elements exists...");
		}
		else
		{
			System.out.println("No elements exists...");
		}
		PreCondition.closeBrowser(driver);
	}

}
