package tim.QAWorks.com.qa.works.com.page;

import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qaWorksHomePage {
	private WebDriver driver;
	private static Logger qaWorksLog = Logger.getLogger(qaWorksHomePage.class);

	public qaWorksHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contact")
	WebElement contactLink;

	public void getHomePage(String homePageTitle) {
		File file = new File("src/main/resources/url.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("homePageURL"));
		driver.manage().window().maximize();
		assertThat(driver.getTitle(),
				CoreMatchers.containsString(homePageTitle));
		qaWorksLog.info("I am able to navigate to the " + homePageTitle);
	}
	
	public contactUsPage clickOnContactLink(){
		contactLink.click();
		qaWorksLog.info("I am able to click on the contact us link");
		return PageFactory.initElements(driver, contactUsPage.class);
		
	}
}
