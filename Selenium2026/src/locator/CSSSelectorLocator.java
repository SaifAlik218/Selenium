package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorLocator {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement emailAddressField = driver.findElement(By.cssSelector("input[name='email']"));
		emailAddressField.sendKeys("Admin");
		driver.manage().window().minimize();
		driver.quit();

	}

}
