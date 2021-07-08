package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath="//div[text()='Setting']") private WebElement settings;


	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getSettings() {
		return settings;
	}


	//action performing method

	public void clicksettings()
	{
		settings.click();
	}







}
