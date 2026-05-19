package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class ContainsSpecificWord {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.myntra.com/");
		List<WebElement> specificWord = driver.findElements(By.tagName("li"));
		for (WebElement searchSpecificWord : specificWord) {
			if (searchSpecificWord.getText().toLowerCase().contains("sale")) {
				System.err.println("text:"+ searchSpecificWord.getText());
			}
		}
		PreCondition.closeBrowser(driver);
	}
}
