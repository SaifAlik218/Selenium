package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class MethodsOfWebElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		WebElement nameTextField = driver.findElement(By.id("name"));
		nameTextField.sendKeys("Saif");
		Thread.sleep(3000);
		nameTextField.clear();
		Thread.sleep(3000);
		WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
		registerButton.submit();
		Thread.sleep(3000);
		registerButton.click();
		System.out.println("Text value of registerButton: " + registerButton.getText());
		System.out.println("Attribute Value of registerButton: " + registerButton.getAttribute("class"));
		System.out.println("Css Value of registerButton: " + registerButton.getCssValue("background-color"));
		System.out.println("Tag name of registerButton: " + registerButton.getTagName());
		Dimension sizeOfRegisterButton = registerButton.getSize();
		System.out.println("Height of an element " + sizeOfRegisterButton.getHeight());
		System.out.println("Width of an element " + sizeOfRegisterButton.getWidth());
		Point coordinatesOfRegisterButton = registerButton.getLocation();
		System.out.println("X axis of an element " + coordinatesOfRegisterButton.getX());
		System.out.println("Y axis of an element " + coordinatesOfRegisterButton.getY());
		Rectangle captureRectOfRegisterButton = registerButton.getRect();
		System.out.println("Height using rect: " + captureRectOfRegisterButton.height + " width using rect: "
				+ captureRectOfRegisterButton.width + " X axis using rect: " + captureRectOfRegisterButton.x
				+ " Y axis using rect: " + captureRectOfRegisterButton.y);
		PreCondition.closeBrowser(driver);
	}
}
