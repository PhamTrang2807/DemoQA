package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage extends Page{
	public By addButton = By.id("addNewRecordButton");
	public By firstNameId = By.id("firstName");
	public By lastNameId = By.id("lastName");
	public By emailId = By.id("userEmail");
	public By ageId = By.id("age");
	public By salaryId = By.id("salary");
	public By departmentId = By.id("department");
	public By submit = By.id("submit");
	public By searchBoxId = By.id("searchBox");
	public By noRowsFound = By.xpath("//div[text()='No rows found']");
	public By deleteIconFirstRow = By.xpath("//div[contains(text(),'First Name')]/../../../following-sibling::div/div[1]//div[@role='gridcell'][7]//span[@title='Delete']");
	public By deleteIcons = By.xpath("//div[contains(text(),'First Name')]/../../../following-sibling::div/div//div[@role='gridcell'][7]//span[@title='Delete']");
	public By firstNameXpath = By.xpath("//div[contains(text(),'First Name')]/../../../following-sibling::div/div[1]//div[@role='gridcell'][1]");
	public By searchedFirstNameXpath = By.xpath("//*[@role='grid']/div[2]/div[@role='rowgroup'][1]/div/div[1]");
	public By searchedLastNameXpath = By.xpath("//*[@role='grid']/div[2]/div[@role='rowgroup'][1]/div/div[2]");
	public By searchedAgeXpath = By.xpath("//*[@role='grid']/div[2]/div[@role='rowgroup'][1]/div/div[3]");
	public By searchedEmailXpath = By.xpath("//*[@role='grid']/div[2]/div[@role='rowgroup'][1]/div/div[4]");
	public By searchedSalaryXpath = By.xpath("//*[@role='grid']/div[2]/div[@role='rowgroup'][1]/div/div[5]");
	public By searchedDepartmentXpath = By.xpath("//*[@role='grid']/div[2]/div[@role='rowgroup'][1]/div/div[6]");
	public void addInfor(String firstName,String lastName,String email,String age, String salary,String department) {
		searchAccountByKey(firstName);
		if (!isNoRowsFoundDisplayed()) {
			deleteInfor();
		}else {
		driver.findElement(addButton).click();
		driver.findElement(firstNameId).sendKeys(firstName);
		driver.findElement(lastNameId).sendKeys(lastName);
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(ageId).sendKeys(age);
		driver.findElement(salaryId).sendKeys(salary);
		driver.findElement(departmentId).sendKeys(department);
		driver.findElement(submit).sendKeys(Keys.RETURN);
		}
	}
	
	public void deleteInfor() {
		List<WebElement> deleteIconsElements = driver.findElements(deleteIcons);
		for(WebElement e:deleteIconsElements) {
			e.click();
		}
	}
	public WebTablePage(WebDriver dr) {
		super(dr);
	}
	public void searchAccountByKey(String searchKeyword) {
		driver.findElement(searchBoxId).sendKeys(searchKeyword);
	}
	public String getTextByElement(By elementLocator) {
		return driver.findElement(elementLocator).getText();
	}
	public Boolean isNoRowsFoundDisplayed() {
		return driver.findElement(noRowsFound).isDisplayed();
	}
}
