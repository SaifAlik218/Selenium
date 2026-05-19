package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import locator.PreCondition;

public class BlazeApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = PreCondition.openBrowser();
		BlazeSearchFlight.selectSrcAndDest(driver);
		BlazeSelectFlight.searchResults(driver);
		BlazeUserDetailsPage.userDetails(driver);
		PreCondition.closeBrowser(driver);
	}
}
