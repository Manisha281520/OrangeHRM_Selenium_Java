package pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BasePage;

public class LoginPageOr extends BasePage{
	
	public LoginPageOr(WebDriver rdriver) {
		super(rdriver);
		this.driver = rdriver;
		
		
	}
	private WebDriver driver;
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String LOGIN = "//button[@type='submit']";

	public DashboardPage login(String username, String password) {
		driver.findElement(By.name(USERNAME)).sendKeys(username);
		driver.findElement(By.name(PASSWORD)).sendKeys(password);
		driver.findElement(By.xpath(LOGIN)).click();
		return new DashboardPage(driver);

	}

}