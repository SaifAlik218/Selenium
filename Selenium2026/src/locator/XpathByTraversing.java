package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByTraversing {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/dummy.html");
		WebElement kgfTo100 = driver.findElement(By.xpath("//td[text()='KGF']/../td[3]"));
		WebElement twoTo200 = driver.findElement(By.xpath("//td[text()='2']/../td[3]"));
		WebElement bahuBahliTo300 = driver.findElement(By.xpath("//td[text()='Bahubali']/../td[3]"));
		WebElement twoHundredTo2 = driver.findElement(By.xpath("//td[text()='200']/../td[1]"));
		WebElement threeHundredToBahubali = driver.findElement(By.xpath("//td[text()='300']/../td[2]"));
		
		System.out.println("Captured element: "+ kgfTo100);
		System.out.println("Captured element: "+ twoTo200);
		System.out.println("Captured element: "+ bahuBahliTo300);
		System.out.println("Captured element: "+ twoHundredTo2);
		System.out.println("Captured element: "+ threeHundredToBahubali);
		
		
	}

}
