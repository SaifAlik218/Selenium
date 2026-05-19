package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextMethod {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("file:///Users/testuser/Downloads/preview.html");
	driver.manage().window().maximize();
	WebElement click_here = driver.findElement(By.linkText("Click Here for Full Link"));
	click_here.click();
	Thread.sleep(2000);
	driver.manage().window().minimize();
	driver.close();
	}

}
