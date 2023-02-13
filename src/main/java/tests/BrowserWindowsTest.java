package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BrowserWindowsPage;
import pages.ElementsPage;
import pages.HomePage;

public class BrowserWindowsTest {
	WebDriver driver;
	BrowserWindowsPage browser;
	@BeforeMethod
	public void openBrowserWindows() {
		System.setProperty("webdrive.Chrome..driver.", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		HomePage homePage = new HomePage(driver);
		ElementsPage elm = homePage.clickElementButton();;
		browser = elm.clickBrowserWindows();
	}
	
	@Test
	public void isMessageDisplayedCorrectly() {
		Assert.assertEquals(browser.getTextByElement(browser.tabButton), "This is a sample page");
		Assert.assertEquals(browser.getTextByElement(browser.newWindownButton), "This is a sample page");
	}
}
