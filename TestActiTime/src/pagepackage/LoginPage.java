package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(name="username") private WebElement usn;
	@FindBy(name="pwd") private WebElement psw;
	@FindBy(id="loginButton") private WebElement loginBtn;
	@FindBy(xpath ="//span[@class='errormsg' and contains(.,'invalid')]") private WebElement errMsg;


	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getUsn() {
		return usn;
	}



	public WebElement getPsw() {
		return psw;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//generic reusable method to do a valid login
	public void validLoginActiTime(String username,String password)
	{   usn.sendKeys(username);
	psw.sendKeys(password);
	loginBtn.click();	
	}
	//generic reusable method for invalid login
	public void InvalidLoginActiTime(String username,String password) throws InterruptedException
	{  
		usn.clear();
		usn.sendKeys(username);
		psw.sendKeys(password);
		loginBtn.click();
		Thread.sleep(3000);
	}

	//action performing method
	public WebElement getErrMsg() {

		return errMsg;
	}








}
