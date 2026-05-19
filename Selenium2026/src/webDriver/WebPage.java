package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String webPageTitle = driver.getTitle();
		System.out.println("webPageTitle"+ webPageTitle);
		driver.manage().window().minimize();
		driver.close();
	}

}
