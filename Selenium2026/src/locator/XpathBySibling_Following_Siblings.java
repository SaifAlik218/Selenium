package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathBySibling_Following_Siblings {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/dummy.html");
		// Eg 1: Traversing from 100 to 300
		WebElement threeHundred = driver.findElement(By.xpath("//td[text()='100']/../following-sibling::tr[2]/td[3]"));
		System.out.println(threeHundred.getText());
		//Eg 2: Traversing from Sl No. to Bahubali
		WebElement bahubaliText = driver.findElement(By.xpath("//td[text()='Sl. no']/../following-sibling::tr[3]/td[2]"));
		System.out.println(bahubaliText.getText());
		driver.manage().window().minimize();
		driver.quit();
	}

}
