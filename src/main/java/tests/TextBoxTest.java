package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest {
	WebDriver driver;
	TextBoxPage textBoxPage;

	@BeforeMethod
	public void openWebsite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com");	
		textBoxPage = new TextBoxPage(driver);
		textBoxPage.openURL("https://demoqa.com/text-box");
	}
	@Test
	public void submitSuccessfully(){	
		textBoxPage.inputData("Trang","phamtrang28@gmail.com","123","123");
		String actualClassInfor = textBoxPage.getAttributeByClassName(textBoxPage.showInforClassName, "class");
		Assert.assertTrue(actualClassInfor.contains("col-md-12"), "Testcase Pass");
	}
	
	@Test
	public void submitWrong() throws InterruptedException { 
		textBoxPage.inputData("Trang","phamtrang28","123","123");
		Thread.sleep(2000);
		
		String actualClassEmail = textBoxPage.getAttributeByClassName(textBoxPage.emailId, "class");
		Assert.assertTrue(actualClassEmail.contains("field-error"), "Testcase fail");
	}
	
}
