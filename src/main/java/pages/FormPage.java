package pages;

import java.awt.RenderingHints.Key;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FormPage extends Page{
	public By radioMale = By.id("gender-radio-1");
	public By radioFeMale = By.id("gender-radio-2");
	public By radioOther = By.id("gender-radio-3");
	public By hobby1 = By.id("hobbies-checkbox-1");
	public By hobby2 = By.id("hobbies-checkbox-2");
	public By hobby3 = By.id("hobbies-checkbox-3");
	public By headerPopup = By.id("example-modal-sizes-title-lg");
	public By formClass = By.id("userForm");
	public By practicesFormXpath = By.xpath("//span[contains(text(), 'Practice Form')]");
	public FormPage(WebDriver dr) {
		super(dr);
	}

	public void clickPractive() {
		driver.findElement(practicesFormXpath).click();
	}
		public void inputData(String fistName, String lastName, String gender,String birthDay,String hobbyType, String mobileNumber) throws InterruptedException {
			String path = "C:\\Autotesttool\\1.Document\\Semina.xlsx";
			driver.findElement(By.id("firstName")).sendKeys(fistName);
			driver.findElement(By.id("lastName")).sendKeys(lastName);
			selectGender(gender);
			driver.findElement(By.id("userNumber")).sendKeys(mobileNumber);
			driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.findElement(By.id("dateOfBirthInput")).sendKeys(birthDay);
			driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.ENTER);
			if(hobbyType == "music") {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", findElementByLocator(hobby3));
			}
			WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",uploadPicture);
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", uploadPicture);
			StringSelection str = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//			selectHobbies(hobbyType);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.body.style.zoom='67%';");
			driver.findElement(By.id("submit")).sendKeys(Keys.RETURN);
		}
		
		public void selectGender(String genderType) {
			if(genderType == "Male") {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", findElementByLocator(radioMale));
			}else if (genderType == "Fe-Male"){
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", findElementByLocator(radioFeMale));
				}else {
					((JavascriptExecutor) driver).executeScript("arguments[0].click()", findElementByLocator(radioOther));
				}
		}	
		
		public void selectHobbies(String hobbyType) {
			switch (hobbyType) {
			case "sport": {
				findElementByLocator(hobby1).sendKeys(Keys.RETURN);
			}
			case "reading": {
				findElementByLocator(hobby2).sendKeys(Keys.RETURN);
			}
			case "music": {
				findElementByLocator(hobby3).sendKeys(Keys.RETURN);
			}
			case "sport&reading": {
				findElementByLocator(hobby1).sendKeys(Keys.RETURN);
				findElementByLocator(hobby2).sendKeys(Keys.RETURN);
			}
			case "sport&music":{
				findElementByLocator(hobby1).sendKeys(Keys.RETURN);
				findElementByLocator(hobby3).sendKeys(Keys.RETURN);
			}
			case "music&reading": {
				findElementByLocator(hobby2).sendKeys(Keys.RETURN);
				findElementByLocator(hobby3).sendKeys(Keys.RETURN);
			}
			case "sport&music&reading": {
				findElementByLocator(hobby1).sendKeys(Keys.RETURN);
				findElementByLocator(hobby2).sendKeys(Keys.RETURN);
				findElementByLocator(hobby3).sendKeys(Keys.RETURN);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + hobbyType);
			}
		}
}
