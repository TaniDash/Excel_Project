package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankCashMenuPage extends BasePage {
	WebDriver driver;

	public BankCashMenuPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy (how=How.XPATH, using="//a[contains(text(), 'New Account')]") WebElement NEW_ACCOUNT_ELEMENT;
	@FindBy (how=How.XPATH, using="//div[@class='ibox-title']") WebElement ADD_NEW_ACCOUNT_HEADER_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@id='account' and @type='text']") WebElement ACCOUNT_TITLE_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@id='description']") WebElement DESCRIPTION_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@id='balance']") WebElement INITIAL_BALANCE_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@id='account_number']") WebElement ACCOUNT_NUMBER_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@id='contact_person' and @name='contact_person']") WebElement CONTACT_PERSON_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@id='contact_phone']") WebElement PHONE_ELEMENT;
	@FindBy (how=How.XPATH, using="//input[@name='ib_url']") WebElement BANK_URL_ELEMENT;
	@FindBy (how=How.XPATH, using="//button[contains(text(), ' Submit')]") WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy (how=How.XPATH, using="//button[@class='btn btn-primary']") WebElement OK_ELEMENT;
	
	
	public void clickNewAccountMenu() {
		NEW_ACCOUNT_ELEMENT.click();
	}
	
	public void verifyNewAccountPage() {
		Assert.assertEquals(ADD_NEW_ACCOUNT_HEADER_ELEMENT.getText(), "Add New Account", "Wrong Page!!");
		System.out.println(ADD_NEW_ACCOUNT_HEADER_ELEMENT.getText());
	}
	
	String insertedTitle;
	public void insertAccountTitle(String title) {
		insertedTitle= title+getRandomNum(999);
		ACCOUNT_TITLE_ELEMENT.sendKeys(insertedTitle);
	}
	
	
	public void insertDescription(String des) {
		DESCRIPTION_ELEMENT.sendKeys(des);
	}
	
	public void insertInitialBalance(String balance) {
		INITIAL_BALANCE_ELEMENT.sendKeys(balance+getRandomNum(99));
	}

	public void insertAccountNum(String acNum) {
		ACCOUNT_NUMBER_ELEMENT.sendKeys(acNum);
	}
	
	public void insertContactPerson(String person) {
		CONTACT_PERSON_ELEMENT.sendKeys(person);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone);
	}
	
	public void insertBankUrl(String url) {
		BANK_URL_ELEMENT.sendKeys(url);
	}
	
	public void clickSubmitButton() throws InterruptedException {
		SUBMIT_BUTTON_ELEMENT.click();
		Thread.sleep(3000);
	}
	
	//table/tbody/tr[3]/td[1]
	//table/tbody/tr[4]/td[1]
	//table/tbody/tr[i]/td[1]/following-sibling::td[2]/a[3]
	
		String before_xpath = "//table/tbody/tr[";
		String after_xpath = "]/td[1]";
		String after_xpath_delete= "]/td[1]/following-sibling::td[2]/a[3]";
		
			
		public void verifyEnteredTitleAndDelete() throws IOException {
			List<WebElement>rows= driver.findElements(By.xpath("//table/tbody/tr"));
			int rowCount= rows.size();
			System.out.println(rowCount);
			
			for (int i =2; i<=rowCount; i++) {
				String newTitle= driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				//System.out.println(newTitle);
			
				if(newTitle.contains(insertedTitle)) {
					System.out.println("Inserted title exists.");
					driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
					OK_ELEMENT.click();	
//					Date currentDate = new Date();
//					String label= currentDate.toString().replace(" ", "-").replace(":", "-");
//					File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//					FileUtils.copyFile(screenshotFile, new File (".//screenshots//"+ label+ ".png"));
				}
			}	
		}	
		
		public void verifyDeletedAccount() throws IOException {
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/th[3]")).getText(), "Manage");
		Date currentDate = new Date();
		String label= currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File (".//screenshots//"+ label+ ".png"));
		}
		
		
}
