package tim.QAWorks.com.qa.works.com.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;

public class contactUsPage {

	private static WebDriver driver;
	private static Logger qaWorksLog = Logger.getLogger(contactUsPage.class);

	public contactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "ctl00_MainContent_NameBox")
	WebElement nameField;

	@FindBy(id = "ctl00_MainContent_EmailBox")
	WebElement emailField;

	@FindBy(id = "ctl00_MainContent_MessageBox")
	WebElement messageField;
	
	@FindBy (id="ctl00_MainContent_SendButton")
	WebElement sendButton;
	

	public void inputName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
		qaWorksLog.info(name + " is input to the name field");
	}

	public void inputEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		qaWorksLog.info(email + " is input to the email field");
	}

	public void inputMessage(String message) {
		messageField.clear();
		messageField.sendKeys(message);
		qaWorksLog.info(message + " is input to the name field");
	}

	public void fillInTheContactDetail(DataTable table) {
		List<List<String>> contactDetails = table.raw();
		nameField.sendKeys(contactDetails.get(0).get(1));
		qaWorksLog.info(contactDetails.get(0).get(1) + " is input to the name field");
		emailField.sendKeys(contactDetails.get(1).get(1));
		qaWorksLog.info(contactDetails.get(1).get(1) + " is input to the email field");
		messageField.sendKeys(contactDetails.get(2).get(1));
		qaWorksLog.info(contactDetails.get(2).get(1) + " is input to the message field");
		sendButton.click();
		qaWorksLog.info("Send button is clicked");

	}
}
