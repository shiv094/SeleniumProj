package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BaseClass.RootClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginPage;
import utility.ReadProperty;

public class SD_Login extends RootClass {
	LoginPage login=new LoginPage();
	
	
	@Given("^I am o n the lgin page facebook$")
	public void i_am_o_n_the_lgin_page_facebook() throws Throwable {
		driver.get(ReadProperty.loadProperty("url", "config"));
		//ReadProperty.loadProperty("url", "config");
	    
	}

	@When("^I enter the\"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_the_and(String username, String password) throws Throwable {
		
	    login.loginToApp(username, password);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		
	   
	}

	@Then("^I am able to successfully login$")
	public void i_am_able_to_successfully_login() throws Throwable {
		
	    
	}

}
