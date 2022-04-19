package page;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListAccountPage {
	WebDriver driver;
	
	public ListAccountPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy (how=How.XPATH, using="//tbody/tr/th[3]") WebElement EDIT_ELEMENT;

	public void verifyDeletedAccount() throws IOException {
		Assert.assertEquals(EDIT_ELEMENT.getText(), "Manage");
		Date currentDate = new Date();
		String label= currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File (".//screenshots//"+ label+ ".png"));
		}

		
	
	
	
	
}
