package modules;

import static constants.Constants.CHROME;
import static constants.Constants.CHROME_DRIVER;
import static constants.Constants.CHROME_DRIVER_KEY;
import static constants.Constants.DRIVER_FOLDER;
import static constants.Constants.EMPTY_STRING;
import static constants.Constants.FIREFOX;
import static constants.Constants.FIREFOX_DRIVER;
import static constants.Constants.FIREFOX_DRIVER_KEY;
import static constants.Constants.WINDOWS;
import static constants.Constants.WINDOWS_APP_SUBFIX;
import static utils.PropertiesManager.getProperty;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver webDriver;
	static Map<String, String> browserDriverMap = new HashMap<>();
	static {
		browserDriverMap.put(CHROME, CHROME_DRIVER);
		browserDriverMap.put(FIREFOX, FIREFOX_DRIVER);
		
		browserDriverMap.put(CHROME_DRIVER, CHROME_DRIVER_KEY);
		browserDriverMap.put(FIREFOX_DRIVER, FIREFOX_DRIVER_KEY);
		
	}

	public static WebDriver getBrowserDriver(String browserName, String url) {

		// Find driver path
		String osType = System.getProperty("os.name");
		String driverName = browserDriverMap.get(browserName);
		String driverPath = (new File(getProperty(DRIVER_FOLDER))).getAbsolutePath();
		driverPath += "/" + driverName + (osType.toUpperCase().contains(WINDOWS) ? WINDOWS_APP_SUBFIX : EMPTY_STRING);
		System.out.println(driverPath);

		// Set driver path to system property
		System.setProperty(browserDriverMap.get(driverName), driverPath);

		// Initialize web driver
		if (browserName.toLowerCase().contains(CHROME)) {
			webDriver = new ChromeDriver();
		} else if (browserName.toLowerCase().contains(FIREFOX)) {
			webDriver = new FirefoxDriver();
		}

		// Open browser
		webDriver.get(url);
		webDriver.switchTo().window(webDriver.getWindowHandle());
		webDriver.manage().window().maximize();
		
		return webDriver;
	}
}
