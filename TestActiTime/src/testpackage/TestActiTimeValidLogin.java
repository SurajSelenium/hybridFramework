package testpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagepackage.LoginPage;
@Listeners(CustomListner.class)
public class TestActiTimeValidLogin extends BaseTest{


	@Test
	public void actiTimeValidLoginTest() throws IOException
	{

		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");
		LoginPage lp = new LoginPage(driver);
		lp.validLoginActiTime(username, password);// login to the application

		WebDriverCommonLib wb = new WebDriverCommonLib();
		//use webDriverwait to verify the homePage
		wb.waitForPageLoad(30, "Enter123");
		String homePageTitle = wb.getTitleOfTheWebPage();
		//hard assert
		Assert.assertEquals(homePageTitle, "actiTIME - Enter Time-Track");
	}

}
