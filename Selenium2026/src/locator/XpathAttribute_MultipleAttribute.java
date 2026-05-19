package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAttribute_MultipleAttribute {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		WebElement nameTextField = driver.findElement(By.xpath("//input[@id='name']"));
		nameTextField.sendKeys("Saif");
		WebElement emailTextField = driver.findElement(By.xpath("//input[@type='email']"));
		emailTextField.sendKeys("Saif@test.com");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@name='password' and @id='password']"));
		passwordTextField.sendKeys("Saif@test");
		WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
		registerButton.click();
		PreCondition.closeBrowser(driver);
	}

}
