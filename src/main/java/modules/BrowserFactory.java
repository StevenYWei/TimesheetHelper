package modules;

import static constants.Constants.CHROME;
import static constants.Constants.FIREFOX;
import static utils.FileManagement.getFileAbsolutePath;
import static utils.PropertiesManager.getProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver webDriver;

	public static WebDriver getBrowserDriver(String browserName, String url) {

		String driverPath = getFileAbsolutePath(getProperty(browserName));
		System.out.println(driverPath);
		System.setProperty(getProperty(browserName + ".driver.key"), driverPath);

		if (browserName.toLowerCase().contains(CHROME)) {
			webDriver = new ChromeDriver();
		} else if (browserName.toLowerCase().contains(FIREFOX)) {
			webDriver = new FirefoxDriver();
		}

		webDriver.get(url);
		webDriver.switchTo().window(webDriver.getWindowHandle());
		webDriver.manage().window().maximize();
		return webDriver;
	}
}
