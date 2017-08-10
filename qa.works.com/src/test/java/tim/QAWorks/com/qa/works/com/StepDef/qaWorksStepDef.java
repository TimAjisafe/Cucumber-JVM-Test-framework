package tim.QAWorks.com.qa.works.com.StepDef;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tim.QAWorks.com.qa.works.com.page.contactUsPage;
import tim.QAWorks.com.qa.works.com.page.qaWorksHomePage;
import tim.QAWorks.com.qa.works.com.page.shareDriver;

public class qaWorksStepDef {
	private qaWorksHomePage QHP;
	private contactUsPage  CHP;
	
	public qaWorksStepDef(shareDriver driver){
		QHP = PageFactory.initElements(driver, qaWorksHomePage.class);
		CHP = PageFactory.initElements(driver, contactUsPage.class);
	}  

	@Given("^I am on the \"([^\"]*)\"$")
	public void I_am_on_the(String homePageTitle) throws Throwable {
		QHP.getHomePage(homePageTitle);
	}

	@When("^I navigate to the contact us page$")
	public void I_navigate_to_the_contact_us_page() throws Throwable {
		QHP.clickOnContactLink();
	}

	@Then("^I should be able to contact QAWorks with the following information$")
	public void I_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable table) throws Throwable {
		CHP.fillInTheContactDetail(table);
		Thread.sleep(5000);
	}
}
