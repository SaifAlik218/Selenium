package webDriver;

import org.openqa.selenium.WebDriver;

import locator.PreCondition;

public class Navigates {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.navigate().to("https://demoapps.qspiders.com/ui?scenario=1");
		driver.navigate().to("https://news.google.com/home");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.quit();
	}

}
