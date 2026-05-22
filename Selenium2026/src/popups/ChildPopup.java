package popups;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locator.PreCondition;

public class ChildPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//button[text()='view more'])[2]")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			String childWindowTitle = driver.getTitle();
			if (!childWindowTitle.contains("High-Performance")) {
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
//				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindow);
		driver.close();
//		PreCondition.closeBrowser(driver);
	}

}
