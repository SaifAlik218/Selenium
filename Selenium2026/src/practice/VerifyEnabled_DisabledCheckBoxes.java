package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class VerifyEnabled_DisabledCheckBoxes {
	

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get(PreCondition.checkbox);
		List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
		int isChecked = 0;
		int isDisabled = 0;
		for (WebElement checkBoxStatus : checkBoxes) 
		{
			if (checkBoxStatus.isSelected()) 
			{
				isChecked++;	
			}
			if (!checkBoxStatus.isSelected()){
				isDisabled++;
			}
		}
		System.out.println("Selected check boxes: "+ isChecked);
		System.out.println("unselected check boxes: "+ isDisabled);
		PreCondition.closeBrowser(driver);
	}

}
