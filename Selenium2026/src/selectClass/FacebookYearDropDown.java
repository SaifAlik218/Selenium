package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class FacebookYearDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.facebook.com/reg/?entry_point=login&next=");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Year']/..")).click();
		List<WebElement> yearDropdown = driver
				.findElements(By.xpath("//div[@aria-label='Select day']//div[@role='option']"));
		try{
			for (int i = 0; i < yearDropdown.size(); i++) {
				String text = yearDropdown.get(i).getText();
				if(text.equals("2027"))
				{
					yearDropdown.get(i).click();
					Thread.sleep(3000);
					System.out.println("Selected year: "+ text);
					break;
				}
			}
		}
		catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		PreCondition.closeBrowser(driver);
	}

}
