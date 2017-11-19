package app;

import modules.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesManager;

import static constants.Constants.URL;
import static constants.Constants.WEB_DRIVER;
import static utils.PropertiesManager.*;

public class AppRun {

	static WebDriver webDriver;
	static LoginPage login;
	static MainPage mainPage;
	static TimeSheetPage timeSheetPage;
	static UploadDoc uploadDoc;

	static {
		PropertiesManager pm = new PropertiesManager();
		webDriver = BrowserFactory.getBrowserDriver(getProperty(WEB_DRIVER), getProperty(URL));

		login = PageFactory.initElements(webDriver, LoginPage.class);
		mainPage = PageFactory.initElements(webDriver, MainPage.class);
		timeSheetPage = PageFactory.initElements(webDriver, TimeSheetPage.class);
		uploadDoc = PageFactory.initElements(webDriver, UploadDoc.class);
	}

	public static void main(String[] args) {

		login.login();
		mainPage.goToManageTimeSheet();
		timeSheetPage.fillAllDaysAndSave();
		uploadDoc.fillCommentAndUploadFile();

	}

}
