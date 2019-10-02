package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\features\\",tags={"@LoginValid"},
glue={"stepDefination","hooks"})

public class Runner extends AbstractTestNGCucumberTests {
	@AfterClass
	public void test()
	{
		
	}
	

}
