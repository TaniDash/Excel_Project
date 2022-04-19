package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader excelRead= new ExcelReader("mockData\\Bank_Cash_NewAccount.xlsx");
	String username= excelRead.getCellData("LoginInfo", "Username", 2);
	String password= excelRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin()  {
		
		driver= BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUsername(username);
		login.insertPassword(password);
		login.clickSigninbutton();
		
		DashboardPage dashboard= PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardPage();
		
		
		//BrowserFactory.tearDown();
		
	}
	
	
}
