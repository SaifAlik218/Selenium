package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://trello.com/");
		WebElement loginLink = driver
				.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']"));
		loginLink.click();
		wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
		WebElement emailTextField = driver.findElement(By.id("username"));
		emailTextField.sendKeys("saifalik218@gmail.com");
		WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
		continueButton.submit();
		WebElement pwdTextField = driver.findElement(By.id("password"));
		pwdTextField.sendKeys("Sadikakhan@123");
		WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
		loginButton.submit();
		wait.until(ExpectedConditions.urlToBe("https://trello.com/u/saifalikhan31/boards"));
		WebElement createNewBoard = driver.findElement(By.xpath("//span[text()='Create new board']"));
		createNewBoard.click();
		WebElement boardTitle = driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
		boardTitle.sendKeys("Selenium");
		WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
		createButton.submit();
		WebElement profile = driver.findElement(By.xpath(
				"//div[@data-testid='header-member-menu-avatar']//span[@title='Saif Ali Khan (saifalikhan31)']"));
		profile.click();
		WebElement logoutButton = driver.findElement(By.xpath("//span[text()='Log out']"));
		logoutButton.click();
		wait.until(ExpectedConditions.titleIs("Log out of your Atlassian account - Log in with Atlassian account"));
		WebElement mainLogoutButton = driver.findElement(By.xpath("//span[text()='Log out']"));
		mainLogoutButton.submit();
		driver.manage().window().minimize();
		driver.quit();

	}

}
