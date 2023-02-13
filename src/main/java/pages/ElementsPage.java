package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends Page{

	public By webTableIcon = By.xpath("//span[text()='Web Tables']");
	public By textBoxIcon = By.xpath("//span[text()='Text Box']");
	public By chbIcon = By.xpath("//span[text()='Check Box']");
	public By browserWindows = By.xpath("//span[contains(text(), 'Browser Windows')]");
	
	public TextBoxPage clickTextBoxButton() {
		driver.findElement(textBoxIcon).click();
		return new TextBoxPage(driver);
	}
	
	public CheckBoxPage clickCheckBoxButton() {
		driver.findElement(chbIcon).click();
		return new CheckBoxPage(driver);
	}
	
	public WebTablePage clickWebTable() {
		WebElement elmWebTable = driver.findElement(webTableIcon);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elmWebTable);
		elmWebTable.click();
		return new WebTablePage(driver);
	}
	
	public BrowserWindowsPage clickBrowserWindows() {
		driver.findElement(browserWindows).click();
		return new BrowserWindowsPage(driver);
	}
	public ElementsPage(WebDriver dr) {
		super(dr);
	}
}
