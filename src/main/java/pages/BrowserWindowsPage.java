package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage extends Page{
	public By tabButton= By.id("tabButton");
	public By newWindownButton = By.id("windowButton");
	public By messageWindowButton = By.id("messageWindowButton");
	
	public BrowserWindowsPage(WebDriver dr) {
		super(dr);
	}
	
	public String getTextByElement(By elementButton) {
		return driver.findElement(elementButton).getText();
	}
}
