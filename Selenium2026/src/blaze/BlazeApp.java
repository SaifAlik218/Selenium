package blaze;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import locator.PreCondition;

public class BlazeApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		BlazeUserDetailsPage.userDetails();
	}
}
