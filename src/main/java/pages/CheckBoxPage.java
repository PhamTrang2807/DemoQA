package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page {
	public By chbHome = By.xpath("//label[@for='tree-node-home']/span[1]/*[name()='svg']");
	public CheckBoxPage(WebDriver dr) {
		super(dr);
		driver = dr;
	}
	
	public boolean isHomeCheckBox() {
		boolean result = true;
		String classValue = driver.findElement(chbHome).getAttribute("class");
		if(classValue.contains("uncheck")) {
			result = false;
		}
		return result;		
	}
	
	public void clickHomeCheckBox() {
		driver.findElement(chbHome).click();
	}
	
	public String getHomeText() {
		String result = "";
		List<WebElement> resultElements = driver.findElements(By.xpath("//div[@id='result']/span"));
		for(WebElement e:resultElements) {
			result = result + " " + e.getText();
		}
		return result.trim();
	}
	public CheckBoxPage clickToggle() {
		driver.findElement(By.xpath("//button[@aria-label='Toggle']")).click();
		return new CheckBoxPage(driver);
	}
	
	public boolean isCheckAll() {
		boolean result = true;
		String classValue = driver.findElement(chbHome).getAttribute("class");
		if(classValue.contains("half-check") || classValue.contains("uncheck")) {
			return false;
		}
		
		return result;
	}
	public String showCheckBox() {
		String result = "";
		List<WebElement> resultCheckBox = driver.findElements(By.xpath("//span[@class='rct-title']"));
//		if(resultCheckBox.)
		for(WebElement e:resultCheckBox) {
			result = result + e.getText() + " ";
		}
		return result;
	}
}
