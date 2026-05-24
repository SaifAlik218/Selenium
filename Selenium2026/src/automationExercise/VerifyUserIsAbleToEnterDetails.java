package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyUserIsAbleToEnterDetails extends VerifyUserIsAbleToEnterNameAndAdress {
	protected static String signPageURL = "https://automationexercise.com/signup";
	protected static String targetURL = "https://automationexercise.com/account_created";
	protected static String password = "saif1234@1234";
	protected static String month = "March";
	protected static String year = "2019";
	protected static String lastName = "Khan";
	protected static String companyDomainName = "TestYantra";
	protected static String address = "304 singapore drive";
	protected static int dayIndex = 8;
	protected static String country = "Singapore";
	protected static String stateName = "Karnataka";
	protected static String cityName = "Bangalore";
	protected static String zipCodeValue = "560114";
	protected static String mobileNumber = "8147100694";
	protected static FluentWait<WebDriver> fluentwait;
	protected static JavascriptExecutor js;
	protected static WebDriverWait wait;

	public static WebDriver enterUserDetails() {
		// driver is already setup at inherited parent method
		enterUserAndEmailAddress();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		fluentwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(200));
		try {
			if (driver.getCurrentUrl().equals(signPageURL)) {
				enterPersonalDetails();
				selectDOB();
				enterAddress();
				createAccount();
				verifyAccount();
			} else {
				System.out.println("incorrect URL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void enterPersonalDetails() {
		WebElement userNameField = fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		String enteredUsername = userNameField.getAttribute("value");
		if (enteredUsername.contains(userName)) {
			System.out.println(enteredUsername + " User name field has correct name");
		} else {
			System.out.println(enteredUsername + " incorrect user name");
		}
		WebElement titleRadioButton = fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Mr']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Mr']")));
		titleRadioButton.click();
		WebElement emailAddressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		if (!emailAddressField.isEnabled()) {
			System.out.println("Email address field is disabled");
		} else {
			System.out.println("Email address field is enabled");
		}
		WebElement scroll = driver.findElement(By.xpath("//label[text()='First name ']"));
		Point locationOfFirstName = scroll.getLocation();
		int x = locationOfFirstName.getX();
		int y = locationOfFirstName.getY();
		js.executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
		WebElement passwordField = fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordField.sendKeys(password);
	}

	public static void selectDOB() {
		WebElement dayDropdown = fluentwait.until(ExpectedConditions.elementToBeClickable(By.id("days")));
		Select selectDayDropDown = new Select(dayDropdown);
		selectDayDropDown.selectByIndex(dayIndex);
		WebElement monthDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("months")));
		Select selectMonthDropDown = new Select(monthDropDown);
		selectMonthDropDown.selectByVisibleText(month);
		WebElement yearDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("years")));
		Select selectYearDropDown = new Select(yearDropDown);
		selectYearDropDown.selectByVisibleText(year);
		WebElement newsLetterCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("newsletter")));
		WebElement receiveOptionsCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("optin")));
		receiveOptionsCheckBox.click();
		newsLetterCheckBox.click();
	}

	public static void enterAddress() {
		WebElement firstNameTextField = wait.until(ExpectedConditions.elementToBeClickable(By.id("first_name")));
		js.executeScript("arguments[0].scrollIntoView(true);", firstNameTextField);
		firstNameTextField.sendKeys(userName);
		WebElement lastNameTextField = wait.until(ExpectedConditions.elementToBeClickable(By.id("last_name")));
		lastNameTextField.sendKeys(lastName);
		WebElement companyName = wait.until(ExpectedConditions.elementToBeClickable(By.id("company")));
		companyName.sendKeys(companyDomainName);
		WebElement address1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("address1")));
		address1.sendKeys(address);
		WebElement address2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("address2")));
		address2.sendKeys(address);
		WebElement countryDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		Select selectCountryDropdown = new Select(countryDropDown);
		selectCountryDropdown.selectByVisibleText(country);
		WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
		state.sendKeys(stateName);
		WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
		city.sendKeys(cityName);
		WebElement zipcode = wait.until(ExpectedConditions.elementToBeClickable(By.id("zipcode")));
		zipcode.sendKeys(zipCodeValue);
		WebElement mobileNumberField = wait.until(ExpectedConditions.elementToBeClickable(By.id("mobile_number")));
		mobileNumberField.sendKeys(mobileNumber);
	}

	public static void createAccount() {
		WebElement createAccountCTA = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default")));
		js.executeScript("arguments[0].scrollIntoView(true);", createAccountCTA);
		createAccountCTA.click();
		System.out.println("Account has created sucessfully");
	}

	public static void verifyAccount() {
		wait.until(ExpectedConditions.urlToBe(targetURL));
		if (driver.getCurrentUrl().equals(targetURL)) {
			System.out.println("User has successfully landed on confirmation page");
		} else {
			throw new RuntimeException("Account creation failed");
		}
	}

}
