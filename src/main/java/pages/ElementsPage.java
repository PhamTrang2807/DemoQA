package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page{

	public TextBoxPage clickTextBoxButton() {
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		return new TextBoxPage(driver);
	}
	public ElementsPage(WebDriver dr) {
		super(dr);
	}
}
