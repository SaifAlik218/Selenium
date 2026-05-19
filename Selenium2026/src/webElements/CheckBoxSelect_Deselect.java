package webElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class CheckBoxSelect_Deselect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		List<WebElement> uncheckBox = new ArrayList<WebElement>();
		driver.get("file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/CheckBox.html");
		List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
		for (WebElement checkBox : checkBoxes) 
		{ if(!checkBox.isSelected())
			{
				checkBox.click();
				Thread.sleep(2000);
				uncheckBox.add(checkBox);
			}	
		}
		Collections.reverse(uncheckBox);
		for (WebElement checkBox : uncheckBox) {
			if (checkBox.isSelected()) {
				checkBox.click();
				Thread.sleep(2000);
			}
		}
		PreCondition.closeBrowser(driver);
	}
}
