package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContainsMethod_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		WebElement nameTextField =driver.findElement(By.xpath("//input[contains(@placeholder,'name')]"));
		nameTextField.sendKeys("Saif");
		driver.manage().window().minimize();
		driver.quit();
	}

}
