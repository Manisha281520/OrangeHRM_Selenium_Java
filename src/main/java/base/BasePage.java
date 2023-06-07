package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
private WebDriver driver;
public BasePage(WebDriver driver){
	this.driver=driver;

	
}
	public static final String LOADER_VIEW="//div[@class='loader-view'] ";
	protected void waitfor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}
		catch(Exception e){
			
		}
		
		
	}
	public void waitForLoading() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER_VIEW)));
		
	}
}
