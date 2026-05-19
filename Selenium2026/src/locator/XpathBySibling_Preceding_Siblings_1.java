package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathBySibling_Preceding_Siblings_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		WebElement downloadTab = driver
				.findElement(By.xpath("//span[text()='Documentation']/../../preceding-sibling::li[1]//span[1]"));
		System.out.println(downloadTab.getText());
		driver.manage().window().minimize();
		driver.quit();
	}

}
