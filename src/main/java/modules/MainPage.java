package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

	WebDriver webDriver;

	public MainPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	@FindBy(how = How.XPATH, using="//table[@class='rgMasterTable']/tbody/tr[td[contains(text(),'In Progress')]][last()]/td[@align='right']/div/span/ul/li/a[@class='flyout']")
	private WebElement option;
	
	@FindBy(how = How.XPATH, using="//table[@class='rgMasterTable']/tbody/tr[td[contains(text(),'In Progress')]][last()]/td[@align='right']/div/span/ul/li//a[contains(text(),'Manage Timesheet')]")
	private WebElement timesheetLink;
	
	public void clickOnOption() {
		System.out.println("Found option: " + option.getText());
		option.click();
		System.out.println("Clicked On the Option Button.");
	}
	
	public void clickedOnManageTimesheet() {
		System.out.println("Found link: " + timesheetLink.getText());
		timesheetLink.click();
		System.out.println("Clicked On the timesheetLink.");
	}
	
	public void goToManageTimeSheet() {
		clickOnOption();
		clickedOnManageTimesheet();
	}
	
}
