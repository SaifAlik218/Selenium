package webDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverSetSize_GetSize 
{
	public static void main(String[] args) {
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(650, 500));
		Dimension getSize = driver.manage().window().getSize();
		System.out.println("Browser size"+ getSize);
		driver.close();
	}

}
