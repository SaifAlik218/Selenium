package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locator.PreCondition;

public class ActionX_Y_axis {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/scroll/newTabVertical");
		Thread.sleep(3000);
		WebElement complaint = driver.findElement(By.xpath("//h3[text()='8. Complaints']"));
		Thread.sleep(3000);
		Point coordinates = complaint.getLocation();
		int x = coordinates.getX();
		int y = coordinates.getY();
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).perform();
		PreCondition.closeBrowser(driver);
	}

}
