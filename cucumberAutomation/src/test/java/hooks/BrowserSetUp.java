package hooks;

import java.util.concurrent.TimeUnit;

import BaseClass.RootClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.ReadProperty;
import utility.TestDriver;

public class BrowserSetUp extends RootClass {
	TestDriver tDriver=new TestDriver();
	@Before
	public void setUp(){
		driver=tDriver.initialize();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(ReadProperty.loadProperty("url", "config"));
	}
	@After
	public void tearDown(){
		driver.quit();
		driver=null;
	}

}
