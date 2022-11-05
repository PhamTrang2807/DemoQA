package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page{

	public void inputData(String userName, String userEmail, String currentAddresswrapper, String permanentAddresswrapper) {
		driver.findElement(By.id("userName")).sendKeys(userName);
		driver.findElement(By.id("userEmail")).sendKeys(userEmail);
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddresswrapper);
		driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddresswrapper);
		
		driver.findElement(By.id("submit")).sendKeys(Keys.RETURN);
	}
	
	public TextBoxPage(WebDriver dr) {
		super(dr);
	}

}
