package modules;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.PropertiesManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static constants.Constants.*;

public class LoginPage {

	WebDriver webDriver;

	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	@FindBy(how = How.ID, id = "mainContent_txtUserName")
	private WebElement userNameInput;

	@FindBy(how = How.ID, id = "pass")
	private WebElement passwordInput;

	@FindBy(how = How.ID, id = "mainContent_btnLogin")
	private WebElement loginButton;

	private String userName = PropertiesManager.getProperty(USERNAME);
	private String password = PropertiesManager.getProperty(PASSWORD);

	public void login() {
		System.out.println("Filled userName");
		userNameInput.sendKeys(userName);
		System.out.println("Filled password");
		passwordInput.sendKeys(password);
		System.out.println("Clicked on the login button");
		loginButton.click();
	}

}
