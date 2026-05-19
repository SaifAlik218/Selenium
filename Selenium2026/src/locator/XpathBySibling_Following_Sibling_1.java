package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathBySibling_Following_Sibling_1 {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.selenium.dev/");
		// Eg: Travsersing Downloads to Blog text
		WebElement blogText = driver
				.findElement(By.xpath("//span[text()='Downloads']/../../following-sibling::li[4]//span[1]"));
		System.out.println(blogText.getText());

	}

}
