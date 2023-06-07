package pages.orangehrm;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver rdriver) {
		super(rdriver);
		this.driver= rdriver;
		
	}
	private WebDriver driver;
	
	
}
