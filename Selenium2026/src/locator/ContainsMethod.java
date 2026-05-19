package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContainsMethod {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement forgotPassword =driver.findElement(By.xpath("//a[contains(text(),'forgot')]"));
		forgotPassword.click();
		driver.manage().window().minimize();
		driver.quit();
	}

}
