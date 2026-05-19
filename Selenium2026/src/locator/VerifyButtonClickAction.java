package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyButtonClickAction {

	boolean flag;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/button?sublist=0");
		Thread.sleep(3000);
		WebElement noButton = driver.findElement(By.xpath("//button[@id='btn_two']"));
		noButton.click();
		WebElement yesButton = driver.findElement(By.xpath("//button[@id='btn']"));
		yesButton.click();
		driver.manage().window().minimize();
		driver.quit();
	}
}
