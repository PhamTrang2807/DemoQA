package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page{
	public By emailId = By.id("userEmail");
	public By showInforClassName = By.className("col-md-12");
	
	public void inputData(String userName, String userEmail, String currentAddresswrapper, String permanentAddresswrapper) {
		driver.findElement(By.id("userName")).sendKeys(userName);
		driver.findElement(emailId).sendKeys(userEmail);
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddresswrapper);
		driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddresswrapper);
		
		driver.findElement(By.id("submit")).sendKeys(Keys.RETURN);
	}
	
	public String getAttributeByClassName(By locator, String className) {
		WebElement e = driver.findElement(locator);
		return e.getAttribute(className);
	}
	
	public TextBoxPage(WebDriver dr) {
		super(dr);
		driver = dr;
	}

}
