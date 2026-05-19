package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameLocator {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement emailName = driver.findElement(By.name("email"));
		emailName.sendKeys("Saif");
		WebElement passwordField= driver.findElement(By.name("pass"));
		passwordField.sendKeys("admin");
		driver.manage().window().minimize();
		driver.quit();

	}

}
