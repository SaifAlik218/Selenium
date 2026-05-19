package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Preconditions;

public class XpathBySibling_1 {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.selenium.dev/");
		WebElement documentationButton = driver
				.findElement(By.xpath("//span[text()='Downloads']/../../following-sibling::li[1]"));
		documentationButton.click();
		WebElement documentationPage = driver.findElement(By.xpath("//div[text()='v4.0']/../li[1]/a"));
		System.out.println(documentationPage.getText());
		PreCondition.closeBrowser(driver);
	}

}
