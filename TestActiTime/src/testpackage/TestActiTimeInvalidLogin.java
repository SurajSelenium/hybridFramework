package testpackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagepackage.LoginPage;
@Listeners(CustomListner.class)// this line we are using to make the ItestListner listen to your test case/script
public class TestActiTimeInvalidLogin extends BaseTest{

	@Test
	public void invalidLoginActiTimeTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//object creations
		Flib flib = new Flib();
		LoginPage lp = new LoginPage(driver);
		WebDriverCommonLib wb = new WebDriverCommonLib();

		//get the row count to itterate the for loop for those many rows
		int rc = flib.getRowCount(EXCEL_PATH, "InvalidCredentials");
		for(int i=1;i<=rc;i++)
		{
			String username = flib.readExcel(EXCEL_PATH, "InvalidCredentials", i, 0);
			String password = flib.readExcel(EXCEL_PATH, "InvalidCredentials", i, 1);
			lp.InvalidLoginActiTime(username, password);//login to the application

			WebElement errmsg = lp.getErrMsg();//get the errormsg WebElement
			wb.waitForElement(20);//implicitely wait
			wb.waitForWebELement(30, "invalid", errmsg,"error message");




		}
	}

}
