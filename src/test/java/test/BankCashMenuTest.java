package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.BankCashMenuPage;
import page.DashboardPage;
import page.ListAccountPage;
import page.LoginPage;
import page.NewAccPage;
import util.BrowserFactory;
import util.ExcelReader;

public class BankCashMenuTest  {
	WebDriver driver;
	
	ExcelReader excelRead= new ExcelReader("mockData\\Bank_Cash_NewAccount.xlsx");
	String username= excelRead.getCellData("LoginInfo", "Username", 2);
	String password= excelRead.getCellData("LoginInfo", "Password", 2);
	String accountTitle= excelRead.getCellData("NewAccountInfo", "Account_Title", 2);
	String description= excelRead.getCellData("NewAccountInfo", "Description", 2);
	String initialBalance= excelRead.getCellData("NewAccountInfo", "Initial_Balance", 2);
	String accountNum= excelRead.getCellData("NewAccountInfo", "Account_Number", 2);
	String contactPerson= excelRead.getCellData("NewAccountInfo", "Contact_Person", 2);
	String phoneNum= excelRead.getCellData("NewAccountInfo", "Phone", 2);
	String bankURL= excelRead.getCellData("NewAccountInfo", "URL", 2);
	
	@Test
	public void validUserShouldBeAbleToAddNewAccount() throws InterruptedException, IOException {
		
		driver= BrowserFactory.init();
		
 		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUsername(username);
		login.insertPassword(password);
		login.clickSigninbutton();
		
		DashboardPage dashboard= PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardPage();
		dashboard.clickBankCashMenuButton();
		
		
		BankCashMenuPage bankCash =PageFactory.initElements(driver, BankCashMenuPage.class);
		bankCash.clickNewAccountMenu();
		bankCash.verifyNewAccountPage();
		bankCash.insertAccountTitle(accountTitle);
		bankCash.insertDescription(description);
		bankCash.insertInitialBalance(initialBalance);
		bankCash.insertAccountNum(accountNum);
		bankCash.insertContactPerson(contactPerson);
		bankCash.insertPhone(phoneNum);
		bankCash.insertBankUrl(bankURL);
		bankCash.clickSubmitButton();
		
		NewAccPage newAc =PageFactory.initElements(driver, NewAccPage.class);
		newAc.verifyNewAccPage();
		dashboard.clickListAccountMenu();
		bankCash.verifyEnteredTitleAndDelete();
	//	bankCash.verifyDeletedAccount();

		ListAccountPage listAccountPage= PageFactory.initElements(driver, ListAccountPage.class);
		listAccountPage.verifyDeletedAccount();
		
		
	}
	
	
}