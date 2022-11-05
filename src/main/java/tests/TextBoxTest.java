package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest {
	WebDriver driver;

//	@Test
//	public void submitSuccessfully(){
//		System.setProperty("webdriver.chrome.driver", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
//		driver = new ChromeDriver();
//		
//		//open page: http://shop.demoqa.com
//		driver.get("https://demoqa.com");
//		HomePage homePage = new HomePage(driver);
//		ElementsPage elementElementsPage =  homePage.clickElementButton();
//		TextBoxPage textBoxPage = elementElementsPage.clickTextBoxButton();
//		textBoxPage.inputData("Trang","phamtrang28@gmail.com","123","123");
//	}
//	
	@Test
	public void submitWrong() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autotesttool\\2.Tool\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//open page
		driver.get("https://demoqa.com");
		HomePage homePage = new HomePage(driver);
		ElementsPage elementElementsPage =  homePage.clickElementButton();
		TextBoxPage textBoxPage = elementElementsPage.clickTextBoxButton();
		textBoxPage.inputData("Trang","phamtrang28","123","123");
		Thread.sleep(2000);
	
		WebElement email = driver.findElement(By.id("userEmail"));
		
		String classEmail = email.getAttribute("class");
		if(classEmail.contains("field-error")) {
			System.out.println("Email wrong");
		}
	}
	
}
