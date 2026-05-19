package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkTextMethod {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///Users/testuser/Downloads/preview.html");
		WebElement partialLinkText = driver.findElement(By.partialLinkText("Click Here"));
		partialLinkText.click();
		driver.manage().window().minimize();
		driver.close();

	}

}
