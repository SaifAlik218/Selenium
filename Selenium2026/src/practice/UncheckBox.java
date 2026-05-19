package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class UncheckBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/CheckBox.html");
		List<WebElement> checkedBoxes = driver.findElements(By.tagName("input"));
//		Collections.reverse(checkedBoxes);
		List<WebElement> boxes = new ArrayList<WebElement>();
		for (int i = checkedBoxes.size()-1; i >= 0; i--) {
			WebElement box = checkedBoxes.get(i);
			if (i % 2 == 0 && box.isSelected()) 
			{
				box.click();
				Thread.sleep(500);
			}
		}
		
//		for (WebElement uncheckBoxes : checkedBoxes) {
//			if (uncheckBoxes.isSelected()) {
//				uncheckBoxes.click();
//			}
//
//		}
		PreCondition.closeBrowser(driver);
	}

}
