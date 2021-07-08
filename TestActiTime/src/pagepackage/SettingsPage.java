package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
	//declaration
	@FindBy(xpath="//a[@class='content administration']") private WebElement settings;
	@FindBy(name="firstHierarchyLevelCode")private WebElement dropdown1;
	@FindBy(name="secondHierarchyLevelCode")private WebElement dropdown2;
	@FindBy(name="thirdHierarchyLevelCode")private WebElement dropdown3;



	public SettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization


	public WebElement getSettings() {
		return settings;
	}
	public WebElement getDropdown1() {
		return dropdown1;
	}
	public WebElement getDropdown2() {
		return dropdown2;
	}
	public WebElement getDropdown3() {
		return dropdown3;
	}
	
	
	//action performing method
	
	//to click on settings option
	public void clickSettings()
	{
		settings.click();
	}
	
	








}
