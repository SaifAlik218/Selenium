package locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathByGroupedIndex_1 {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("");
		WebElement xys = driver.findElement(null);
		xys.getTagName();

	}

}
