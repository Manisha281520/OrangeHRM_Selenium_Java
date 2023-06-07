package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactoryOr;
import pages.orangehrm.LoginPageOr;
import pages.orangehrm.AdminPage;


public class BaseTest {

	private WebDriver driver;
	protected LoginPageOr loginpageor;
	protected AdminPage adminPage;
	@BeforeMethod
	public void setup() {
		DriverFactoryOr driverfactory = new DriverFactoryOr();
		try {
			driver = driverfactory.initBrowser(DriverFactoryOr.initProperties());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//method chaining
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(DriverFactoryOr.initProperties().getProperty("url"));
		loginpageor = new LoginPageOr(driver);
		adminPage = new AdminPage(driver);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	protected void waitfor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}
		catch(Exception e){
			
		}
	}
	
}
