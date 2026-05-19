package webDriver;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverGetPosition_SetPosition {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
		Thread.sleep(2000);
		driver.manage().window().setPosition(new Point(400, 340));
		Thread.sleep(2000);
		Point getPosition = driver.manage().window().getPosition();
		System.out.println("Cooridnates of webpage: " + getPosition);
		driver.manage().window().minimize();
		driver.close();

	}

}
