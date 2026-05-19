package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locator.PreCondition;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		boolean flag = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=2");
		Thread.sleep(3000);
		WebElement src = driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		WebElement dest = driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(src, dest).perform();
		PreCondition.closeBrowser(driver);
	}

}
