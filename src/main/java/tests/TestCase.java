package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import common.TestBase;
import pages.ElementsPage;
import pages.HomePage;

public class TestCase {
	TestBase testBase = new TestBase();
	@BeforeMethod
	@Parameters("browser")
	public void openWebsite(String browserName) {
		testBase.openWeb(browserName);
	}
	
	@AfterMethod
	public void closeBrowser() {
		testBase.driver.quit();
	}
}
