package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BaseClass.RootClass;
import utility.ReadProperty;
import utility.UseActions;

public class LoginPage extends RootClass {
	UseActions actions=new UseActions();
	@FindBy(how=How.ID,using="email")
	private static WebElement userId;
	
	@FindBy(how=How.ID,using="pass")
	private static WebElement pass;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	private static WebElement btn_login;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApp(String user,String psw){
		if(user.equals("")){
			actions.setText(userId, ReadProperty.loadProperty("userName", "config"));
		}
		else{
			actions.setText(userId, user);
		}
		if(user.equals("")){
			actions.setText(pass, ReadProperty.loadProperty("password", "config"));
		}
		else{
			actions.setText(pass, user);
		}
		actions.click(btn_login);
		
	}
	
	

}
