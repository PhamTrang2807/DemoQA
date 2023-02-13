package tests;

import org.checkerframework.checker.units.qual.radians;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FormPage;
import pages.HomePage;

public class FormTest {
//	public By formXpath = By.xpath("//div[@class= 'category-cards']/div[2]");
	//span[contains(text(), 'Practice Form')]
	WebDriver driver;
	FormPage formPage;
	
	@BeforeMethod
	public void openWebsite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		HomePage homePage = new HomePage(driver);
		formPage = homePage.clickFormButton();
		formPage.clickPractive();
	}
	
	@Test
	public void submitDataSuccess() throws InterruptedException {
		String firstName = "Trang";
		String lastName = "Pham";
		String gender = "Male";
		String birthDay = "1994/07/28";
		String mobile = "0833572867";
		String hobby = "music";
		formPage.inputData(firstName,lastName,gender,birthDay,hobby,mobile);
		
		String expectedHeader = "Thanks for submitting the form";
		String actualHeder = formPage.findElementByLocator(formPage.headerPopup).getText();
		
		Assert.assertEquals(actualHeder, expectedHeader);
	}
	@Test
	public void submitDataUnsuccess() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.zoom='67%';");
		driver.findElement(By.id("submit")).sendKeys(Keys.RETURN);
		String actualForm = formPage.getAttributeByClassName(formPage.formClass, "class");
		Assert.assertTrue(actualForm.contains("was-validated"), "Testcase Fail");
	}
}
