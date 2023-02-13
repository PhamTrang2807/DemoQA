package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
	public WebDriver driver;
	public Page(WebDriver dr) {
		driver = dr;
	}

	public void openURL(String url) {
		driver.navigate().to(url);
	}
	public CheckBoxPage openCheckBoxPage() {
		HomePage hp = new HomePage(driver);
		ElementsPage elm = hp.clickElementButton();
		CheckBoxPage checkBoxPage = elm.clickCheckBoxButton();
		return checkBoxPage;
	}
	
	public WebElement findElementByLocator(By locator) {
		WebElement elm = driver.findElement(locator);
		return elm;
	}
	
	public String getAttributeByClassName(By locator, String className) {
		WebElement e = driver.findElement(locator);
		return e.getAttribute(className);
	}
}
