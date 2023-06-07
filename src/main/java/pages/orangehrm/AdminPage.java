package pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

import static java.lang.String.format;

import java.util.List;


public class AdminPage extends BasePage {
	

	public AdminPage(WebDriver rdriver) {
		super(rdriver);
		this.driver = rdriver;
	}
		
	private WebDriver driver;
	private static final String USERNAME= "(//input[@class='oxd-input oxd-input--active'])[2]";
	private static final String USERROLE= "//div[label[text()='User Role']]";
	private static final String USERROLEOPTIONS= "//ul/li[node()='%s']";
	private static final String EMPLOYEENAME= "//input[@placeholder='Type for hints...']";
	private static final String STATUS= "//div[label[text()='Status']]";
	private static final String STATUSOPTIONS= "//ul/li[node()='%s']";
	private static final String SEARCH= "//button[@type='submit']";
	public static final String ADD="//button[@type='button']";
	public static final String PASSWORD="(//input[@class='oxd-input oxd-input--active'])[3]";
	public static final String TYPEOFHINTS="//input[@placeholder='Type for hints...']";
	public static final String CONFIRMPASSWORD="(//input[@type='password'])[2]";
	public static final String SAVE="//button[@type='submit']";
	public static final String ADMINMODULE="//span[text()='Admin']";
	
	public static final String TABLE="//div[@role='table']";
	
	public void searchUser(String username, String userrole, String employeename, String status) {
		driver.findElement(By.xpath(ADMINMODULE)).click();
		driver.findElement(By.xpath(USERNAME)).sendKeys(username);
		driver.findElement(By.xpath(USERROLE)).click();
		driver.findElement(By.xpath(format(USERROLEOPTIONS, userrole ))).click();
		driver.findElement(By.xpath(EMPLOYEENAME)).sendKeys(employeename);
		driver.findElement(By.xpath(STATUS)).click();
		driver.findElement(By.xpath(format(STATUSOPTIONS, status))).click();
		driver.findElement(By.xpath(SEARCH)).click();
	}
	public void addUser(String username, String userrole, String hints, String status, String password, String confirmpassword) {
		driver.findElement(By.xpath(ADD)).click();
		driver.findElement(By.xpath(format(USERROLEOPTIONS, userrole ))).click();
		driver.findElement(By.xpath(TYPEOFHINTS)).sendKeys(hints);
		driver.findElement(By.xpath(USERNAME)).sendKeys(username);
		driver.findElement(By.xpath(PASSWORD)).sendKeys(password);
		driver.findElement(By.xpath(CONFIRMPASSWORD)).sendKeys(confirmpassword);
		driver.findElement(By.xpath(SAVE)).click();
	}
	
	public void table() {
		WebElement table= driver.findElement(By.xpath("//div[@role='table']"));
		List<WebElement> rows= table.findElements(By.cssSelector("tbody tr"));
		int rowsize=rows.size();
		System.out.println(rowsize);
	//	List<WebElement> cols=rows.findElements(By.tagName("td"));
		for(int i=0; i<=rowsize; i++)
		{
			rows.get(i).findElement(By.tagName("td"));
		}
		
		
	}
	
	
	
	
	
	
}
