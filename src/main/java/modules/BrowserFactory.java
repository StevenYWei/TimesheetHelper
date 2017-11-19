package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static constants.Constants.CHROME;
import static constants.Constants.FIREFOX;
import static utils.FileManagement.getFileAbsolutePath;
import static utils.PropertiesManager.getProperty;

public class BrowserFactory {
	static WebDriver webDriver;

	public static WebDriver getBrowserDriver(String browserName, String url) {

		String osType = System.getProperty("os.name");
		String driverNameWithExtension = getProperty(browserName);
		if (osType.toUpperCase().contains("WINDOWS")) {
			driverNameWithExtension += ".exe";
		}

		String driverPath = getFileAbsolutePath(driverNameWithExtension);
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
