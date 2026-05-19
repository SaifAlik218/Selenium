package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locator.PreCondition;

public class MultiSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://admirhodzic.github.io/multiselect-dropdown/demo.html");
		Thread.sleep(3000);
		WebElement select1 = driver.findElement(By.xpath("//span[text()='select']"));
		select1.click();
		WebElement select2 = driver.findElement(By.xpath("//span[text()='5 selected']"));
		select2.click();
		Select selectOption1 = new Select(select1);
		List<WebElement> checkBoxes = selectOption1.getOptions();
		for (WebElement options : checkBoxes) {
			System.out.println(options.getText());
		}
		PreCondition.closeBrowser(driver);

	}

}
