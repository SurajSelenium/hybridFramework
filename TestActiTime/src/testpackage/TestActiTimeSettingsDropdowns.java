package testpackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagepackage.LoginPage;

import pagepackage.SettingsPage;

@Listeners(CustomListner.class)
public class TestActiTimeSettingsDropdowns extends BaseTest{
	
	
	@Test
	public void getTheOptionsOfFirstDropdown() throws IOException
	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");
		LoginPage lp = new LoginPage(driver);
		lp.validLoginActiTime(username, password);
		
		//to avoid synchronisation issue we are using explicitly wait
		WebDriverCommonLib wb = new WebDriverCommonLib();
		wb.waitForPageLoad(30, "Enter");
		
		//to click on settings
		SettingsPage sp = new SettingsPage(driver);
		sp.clickSettings();
		
		//to get all the options of first dropdown 
		WebElement firstDropdown = sp.getDropdown1();
		wb.getOptionOfDropdown(firstDropdown);
		
	}
	
	@Test
	public void getTheOptionsOfSecondDropdown() throws IOException
	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");
		LoginPage lp = new LoginPage(driver);
		lp.validLoginActiTime(username, password);
		
		//to avoid synchronisation issue we are using explicitly wait
		WebDriverCommonLib wb = new WebDriverCommonLib();
		wb.waitForPageLoad(30, "Enter");
		
		//to click on settings
		SettingsPage sp = new SettingsPage(driver);
		sp.clickSettings();
		
		//to get all the options of second dropdown 
		WebElement secondDropdown = sp.getDropdown2();
		wb.getOptionOfDropdown(secondDropdown);
	}
	
	
	@Test
	public void getTheOptionsOfThirdDropdown() throws IOException
	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");
		LoginPage lp = new LoginPage(driver);
		lp.validLoginActiTime(username, password);
		
		//to avoid synchronisation issue we are using explicitly wait
		WebDriverCommonLib wb = new WebDriverCommonLib();
		wb.waitForPageLoad(30, "Enter");
		
		//to click on settings
		SettingsPage sp = new SettingsPage(driver);
		sp.clickSettings();
		
		//to get all the options of third dropdown 
		WebElement thirdDropdown = sp.getDropdown3();
		wb.getOptionOfDropdown(thirdDropdown);
	}
	
	
	
	
	
	

}
