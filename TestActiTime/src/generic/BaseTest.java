package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant {
	protected static WebDriver driver;
	
	//@BeforeMethod annotation will alwatys work before @Test
	@BeforeMethod
	public void setUp() throws IOException
	{
		//get the data such as browsername and url from property file
		
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH,"browser");
		String baseUrl = flib.readPropertyData(PROP_PATH, "url");
		//we are using RTP(Run Time Polymorphism to decide which browser we need to launch
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY,CHROME_PATH);
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseUrl);
			
		}
		
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY,GECKO_PATH);
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseUrl);
		}
		
		else
		{
			System.out.println("invalid input");
		}
			
	
	}
	
	//this method will be called once the @test gets failed and the screenshot will be taken with the method name which gets failed
	public void fail(String methodName) 
	{
		
		//handled the exception with the help of try catch
		try
	
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+methodName+".png");
		Files.copy(src, dest);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	

}
