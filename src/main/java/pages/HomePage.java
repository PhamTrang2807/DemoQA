package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
	public ElementsPage clickElementButton() {
		WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementButton);
		elementButton.click();
		return new ElementsPage(driver);
	}
	
	public HomePage(WebDriver dr) {
		super(dr);
	}
	
	
}
