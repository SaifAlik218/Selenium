package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class IdLocator {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement id = driver.findElement(By.id("_R_oiqjbjb9pb6amH1_"));
		id.sendKeys("Saif");
		driver.manage().window().minimize();
		driver.quit();

	}

}
