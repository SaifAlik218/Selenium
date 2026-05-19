package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class SelectAllUncheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/CheckBox.html");
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> uncheck = new ArrayList<WebElement>();
		for (WebElement checkBox : checkBoxes) {
			if (!checkBox.isSelected()) {
				checkBox.click();
				Thread.sleep(1000);
				uncheck.add(checkBox);
			}
		}
		Collections.reverse(uncheck);
		for (WebElement uncheckBox : uncheck) {
			if (uncheckBox.isSelected()) {
				uncheckBox.click();
				Thread.sleep(1000);
			}
		}
		PreCondition.closeBrowser(driver);
	}

}
