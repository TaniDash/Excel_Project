package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage{

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/li[2]/a/span[@class='nav-label']")WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Bank & Cash')]")WebElement BANK_CASH_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Accounts')]")WebElement LIST_ACCOUNT_MENU_ELEMENT;
	@FindBy (how=How.XPATH, using= "//h5[contains(text(), 'Manage Accounts')]") WebElement MANAGE_ACCOUNTS_ELEMENT;

	public void verifyDashboardPage() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Wrong Page!");
		System.out.println(DASHBOARD_HEADER_ELEMENT.getText());
	}

	public void clickBankCashMenuButton() {
		BANK_CASH_MENU_ELEMENT.click();
	}

	public void clickListAccountMenu() {
		LIST_ACCOUNT_MENU_ELEMENT.click();
		Assert.assertEquals(MANAGE_ACCOUNTS_ELEMENT.getText(), "Manage Accounts", "Wrong!!");
		System.out.println(MANAGE_ACCOUNTS_ELEMENT.getText());
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scroll(0,20000)");
	}

}
