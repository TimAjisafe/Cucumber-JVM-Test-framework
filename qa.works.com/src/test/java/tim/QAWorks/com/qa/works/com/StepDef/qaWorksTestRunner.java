package tim.QAWorks.com.qa.works.com.StepDef;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions (format ={"pretty","html:qaWorksTestReport/html/"},features ="src/test/java/feaureFiles/",tags ="@Test1")

public class qaWorksTestRunner {

}
