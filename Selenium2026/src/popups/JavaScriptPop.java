package popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locator.PreCondition;

public class JavaScriptPop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://vinothqaacademy.com/alert-and-popup/");
//		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		driver.findElement(By.xpath("//button[text()='Confirm Alert Box']")).click();
//		alert.dismiss();
		Thread.sleep(3000);
		System.out.println("Alert text: " + alert.getText());
		alert.sendKeys("Yes");
		alert.accept();
		PreCondition.closeBrowser(driver);
	}

}
