package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import BaseClass.RootClass;

public class TestDriver extends RootClass {
	public RemoteWebDriver initialize()
	{
		System.out.println("in driverint");
		Platform current=Platform.getCurrent();
		String firefox=ReadProperty.loadProperty("firefoxbrwser", "config");
		String chrome=ReadProperty.loadProperty("chromebrowser", "config");
		if(driver==null)
		{
			if(firefox.equals("yes"))
			{
				System.out.println("firefox");
				if(current.WINDOWS!=null)
				{
					System.out.println("initialize firefox");
					try{
						driver=new FirefoxDriver();
					}catch(Exception e)
					{
						e.getMessage();
					}
				}
			}else if(chrome.equals("yes"))
			{
				System.out.println("chrome");
				if(current.WINDOWS!=null)
				{
					System.setProperty("webdriver.chrome.driver", "A:\\chromedriver.exe");
					driver=new ChromeDriver();
				}
			}
		}
		return driver;
	}
	public void screenshot()
	{
		String imageName=System.currentTimeMillis()+".png";
		try{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("target\\reports"+imageName));
		}catch(IOException e){
			e.getMessage();
		}
	}
	public WebElement findElement(By arg)
	{
		return null;
	}
	public List<WebElement> findElements(By arg){
		return null;
		
	}
	public String get(String arg){
		  this.driver.get(arg);
		  return arg;
	}
	public String getTitle(){
		return null;
	}
	public String getWindowHandle()
	{
		return null;
		
	}
	public Set<String> getWindowHandls(){
		return null;
	}

}
