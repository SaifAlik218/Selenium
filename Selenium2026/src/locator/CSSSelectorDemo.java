package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CSSSelectorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(5000);
		WebElement userName = driver.findElement(By.cssSelector("input[name='name']"));
		userName.sendKeys("Admin");
		Thread.sleep(2000);
		WebElement emailAddress = driver.findElement(By.cssSelector("input[type ='email']"));
		emailAddress.sendKeys("admin@admin.com");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.cssSelector("input[id ='password']"));
		password.sendKeys("admin@admin.com");
		Thread.sleep(2000);
		WebElement loginButton = driver.findElement(By.cssSelector("button[type ='submit']"));
		loginButton.click();
		driver.manage().window().minimize();
		driver.quit();

	}

}
