package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class NewAccPage extends BasePage {
	WebDriver driver;
	
	public NewAccPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy (how=How.XPATH, using= "//h5[text()='Manage Accounts']") WebElement NEW_ACCOUNT_PAGE_ELEMENT;
	
	
	public void verifyNewAccPage() {
		Assert.assertEquals(NEW_ACCOUNT_PAGE_ELEMENT.getText(), "Manage Accounts","Incorrect Page!");
		System.out.println(NEW_ACCOUNT_PAGE_ELEMENT.getText());	
	}
	
	
	

}
