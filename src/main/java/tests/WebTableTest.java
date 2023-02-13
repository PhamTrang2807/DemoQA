package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest {
	WebDriver driver;
	WebTablePage webtable;
	@BeforeMethod
	public void openWebTable() {
		System.setProperty("webdriver.chrome.driver", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		HomePage homePage = new HomePage(driver);
		ElementsPage elmPage = homePage.clickElementButton();
		webtable = elmPage.clickWebTable();
	}
	
	
	@Test(dataProvider = "AccountInfor")
	public void searchByFirstNameSuccess(String firstName, String lastName, String email, String age, String salary, String department) {
		String keySearch = "tra";
//		String firstName = "Trang";
//		String lastName = "Pham";
//		String email = "phamtrang@gmail.com";
//		String age = "28";
//		String salary = "1000";
//		String department = "MO";
		webtable.addInfor(firstName, lastName, email, age, salary, department);
		webtable.searchAccountByKey(keySearch);
		String actualFirstName = webtable.getTextByElement(webtable.firstNameId);
		Assert.assertTrue(actualFirstName.toLowerCase().contains(keySearch));
		webtable.deleteInfor();
	}
	@Test(dataProvider = "AccountInfor")
	public void registerNewAccountSuccessfully(String firstName, String lastName, String email, String age, String salary, String department) {
		webtable.addInfor(firstName, lastName, email, age, salary, department);
		Assert.assertEquals(webtable.getTextByElement(webtable.searchedFirstNameXpath), firstName);
		Assert.assertEquals(webtable.getTextByElement(webtable.searchedLastNameXpath), lastName);
		Assert.assertEquals(webtable.getTextByElement(webtable.searchedEmailXpath), email);
		Assert.assertEquals(webtable.getTextByElement(webtable.searchedAgeXpath), age);
		Assert.assertEquals(webtable.getTextByElement(webtable.searchedSalaryXpath), salary);
		Assert.assertEquals(webtable.getTextByElement(webtable.searchedDepartmentXpath), department);
	}
	
	@DataProvider(name = "AccountInfor")
	public String[] creatData1() {
		String[] accountInfor = new String[6];
		accountInfor[0] = "Trang";
		accountInfor[1] = "Pham";
		accountInfor[2] = "trang@gmail.com";
		accountInfor[3] = "29";
		accountInfor[4] = "1000";
		accountInfor[5] = "Tester";
		return accountInfor;
	}
	
}
