package modules;

import static constants.Constants.COMMENT;
import static constants.Constants.HOUR;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.PropertiesManager;

public class TimeSheetPage {

	WebDriver webDriver;
	String comment = PropertiesManager.getProperty(COMMENT);
	String hour = PropertiesManager.getProperty(HOUR);
	Boolean[] enableCells = new Boolean[14];
	
	
	@FindBy(how = How.XPATH, using = "//table[contains(@class, 'table')]/tbody/tr[@class='info']/td//span[@class='page-titledivBlueSubSub']")
	private List<WebElement> dateList;
	
	@FindBy(how = How.XPATH, using = "//table[contains(@class, 'table')]/tbody/tr[td/span[contains(text(), 'Project')]]/td//input[@type='Number']")
	private List<WebElement> projectTimeCells;
	
	@FindBy(how = How.XPATH, using = "//table[contains(@class, 'table')]/tbody/tr[td/span[contains(text(), 'Project')]]/td//a")
	private List<WebElement> projectTimeLinks;

	@FindBy(how = How.XPATH, using = "//iframe")
	private WebElement iframe;

	@FindBy(how = How.ID, id = "mainContent_txtComment")
	private WebElement timeComment;

	@FindBy(how = How.ID, id = "mainContent_btnSubmit")
	private WebElement commentSave;
	
	@FindBy(how = How.ID, id = "btnSave")
	private WebElement saveTimesheet;
	
	@FindBy(how = How.ID, id = "btnSubmit")
	private WebElement submitTimesheet;

	public TimeSheetPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	// Figure whether the cell needs to be filled (do not filled holiday or weekends)
	public void getCellsToBeFilled() {
		int index = 0;
		for (WebElement dat : dateList) {
			System.out.println(dat.getAttribute("innerHTML"));
			enableCells[index++] = (!dat.getAttribute("style").equalsIgnoreCase("color: brown;"));
		}
	}
	
	public void fillTime() {
		for(int i = 0; i < enableCells.length; i++) {
			if(enableCells[i] == true) {
				System.out.println("Cell " + i + " is enabled to fill.");
				projectTimeCells.get(i).clear();
				projectTimeCells.get(i).sendKeys(hour);
				projectTimeLinks.get(i).click();
				System.out.println("Clicked on the comment link.");
				
				webDriver.switchTo().frame(iframe);
				System.out.println("Found comment area: " + timeComment.getTagName());

				timeComment.clear();
				timeComment.sendKeys(comment);

				System.out.println("Found save comment button: " + commentSave.getTagName());
				commentSave.click();
				System.out.println("Clicked on the save comment link.");

				webDriver.switchTo().defaultContent();
			}
		}
	}
	
	public void fillAllDaysAndSave() {
		
		System.out.println("Trying to fill in the cell with hour");
		
		getCellsToBeFilled();
		fillTime();
		
		saveTimesheet.click();
		submitTimesheet.click();
		
	}

}
