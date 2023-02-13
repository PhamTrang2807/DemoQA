package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
	public ElementsPage clickElementButton() {
		WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementButton);   //cuon trang xuong duoi
		elementButton.click();
		return new ElementsPage(driver);
	}
	public FormPage clickFormButton() {
		WebElement formtButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formtButton);   //cuon trang xuong duoi
		formtButton.click();
		return new FormPage(driver);
	}
	
	public HomePage(WebDriver dr) {
		super(dr);
	}
	
	
	
	
}
