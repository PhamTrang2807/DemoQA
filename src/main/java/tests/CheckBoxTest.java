package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class CheckBoxTest  extends TestCase{
//	WebDriver driver;
//	CheckBoxPage checkBoxPage;
	
//	@BeforeMethod
//	public void openWebsite() {
////		System.setProperty("webdriver.chrome.driver", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
////		driver = new ChromeDriver();
////		driver.get("https://demoqa.com");
//		HomePage hp = new HomePage(driver);
//		ElementsPage elm = hp.clickElementButton();
//		checkBoxPage = elm.clickCheckBoxButton();
////		checkBoxPage = new CheckBoxPage(driver);		
////		checkBoxPage.openURL("https://demoqa.com/check-box");
//	}
	@Test
	public void verifyCheckBox() {
		CheckBoxPage checkBoxPage = new CheckBoxPage(testBase.driver);
		checkBoxPage.openCheckBoxPage();
		Assert.assertFalse(checkBoxPage.isHomeCheckBox());
		checkBoxPage.clickHomeCheckBox();
		String expectedLabel = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		String actualLabel = checkBoxPage.getHomeText();
		Assert.assertEquals(actualLabel, expectedLabel);
		checkBoxPage.clickToggle();
		Assert.assertTrue(checkBoxPage.isCheckAll());
//		String expectedCheckBoxName = "Desktop" + "/n" + "Document" +"/n" +"Downloads";
//		String actualCheckBoxName = checkBoxPage.showCheckBox();
//		System.out.println(actualCheckBoxName);
//		Assert.assertEquals(actualCheckBoxName, expectedCheckBoxName);
		
	}
	
	
	
}
