package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Preconditions;

public class XpathByGroupedIndex {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/index.html");
		WebElement option4 = driver.findElement(By.xpath("(//input[@type ='text'])[4]"));
		WebElement option1 = driver.findElement(By.xpath("(//input)[1]"));
		System.out.println(option4.getTagName() + " " + option1.getTagName());
		PreCondition.closeBrowser(driver);
	}

}
