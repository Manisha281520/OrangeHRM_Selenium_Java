package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactoryOr {

	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}

	public static Properties initProperties() {
		Properties properties = null;
		try {
			FileInputStream fis = new FileInputStream(".//src/test/resources/properties/global.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public WebDriver initBrowser(Properties properties) throws Exception {

		boolean headless = Boolean.parseBoolean(properties.getProperty("headless"));
		System.out.println("Browser: " + properties.getProperty("browser"));
		switch (properties.getProperty("browser").toLowerCase().trim()) {
//	            case "chromium":
//	                driverThreadLocal.set(new ChromiumDriver());
//	                break;
		case "chrome":
			driverThreadLocal.set(new ChromeDriver());
			break;
		case "firefox":
			driverThreadLocal.set(new FirefoxDriver());
			break;
		case "safari":
			driverThreadLocal.set(new SafariDriver());
			break;
		case "msedge":
			driverThreadLocal.set(new EdgeDriver());
			break;
		}
		getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(properties.getProperty("implicit_wait"))));
		getDriver().manage().window().maximize();
		getDriver().get(properties.getProperty("url"));
		return getDriver();
	}

	public static String takeScreenshot() {
		/*
		 * String path = System.getProperty("user.dir") + "/screenshots/" +
		 * System.currentTimeMillis() + ".png"; TakesScreenshot screenshot =
		 * (TakesScreenshot) getDriver(); File src =
		 * screenshot.getScreenshotAs(OutputType.FILE); try { FileUtils.copyFile(src,
		 * new File(path)); } catch (IOException e) { e.printStackTrace(); } return
		 * path;
		 * 
		 */
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        String base64 = screenshot.getScreenshotAs(OutputType.BASE64);
        return base64;

		}
}
