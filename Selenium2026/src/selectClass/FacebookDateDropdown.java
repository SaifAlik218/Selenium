package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locator.PreCondition;

public class FacebookDateDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.facebook.com/reg/?entry_point=login&next=");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Day']/..")).click();
		Thread.sleep(3000);
		List<WebElement> datesDropdown = driver
				.findElements(By.xpath("//div[@aria-label='Select day']//div[@role='option']"));
		for (int i = 0; i < datesDropdown.size(); i++) {
			try {
				String text = datesDropdown.get(i).getText();
				{
					if (text.equals("1")) {
						datesDropdown.get(i).click();
						System.out.println("Selected date: " + text);
						break;
					}

				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		PreCondition.closeBrowser(driver);
	}

}
